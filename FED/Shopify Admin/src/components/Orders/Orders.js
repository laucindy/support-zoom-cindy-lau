import {
  Button,
  ChoiceList,
  Filters,
  TextField,
  Page,
  ResourceList,
  ResourceItem,
  Badge,
  TextStyle,
  Stack,
  Card,
  Layout,
  Checkbox,
  Tabs,
  Popover,
  Icon
} from "@shopify/polaris";
import React, { useState, useCallback, useEffect } from "react";
import "./Orders.scss";
import { ExportMinor, LocationsMinor, StarFilledMinor, SortMinor } from "@shopify/polaris-icons";
import originalOrderData from "./mockOrderData";

function Orders() {
  const [selectedTab, setSelectedTab] = useState(0);
  const [selectedItems, setSelectedItems] = useState([]);
  const [headingChecked, setHeadingChecked] = useState(false);
  const [queryValue, setQueryValue] = useState(null);

  // sort button and popover
  const [sortPopoverActive, setSortPopoverActive] = useState(true);
  const [sortOptionSelected, setSortOptionSelected] = useState(["dateNewest"]);

  // filters
  const [orderData, setOrderData] = useState(originalOrderData);
  const [orderStatus, setOrderStatus] = useState(null);
  const [paymentStatus, setPaymentStatus] = useState(null);
  const [fulfillmentStatus, setFulfillmentStatus] = useState(null);
  const [taggedWith, setTaggedWith] = useState(null);

  const handleOrderStatusChange = useCallback((value) => setOrderStatus(value), []);
  const handlePaymentStatusChange = useCallback((value) => setPaymentStatus(value), []);
  const handleFulfillmentStatusChange = useCallback((value) => setFulfillmentStatus(value), []);
  const handleTaggedWithChange = useCallback((value) => setTaggedWith(value), []);

  // reset order data
  useEffect(() => {
    if (noFiltersSelected()) {
      setOrderData(originalOrderData);
    } else {
      setOrderData(
        originalOrderData.filter(
          (order) =>
            // setting to true will 'skip' the order attribute when it's undefined (state is null), or false (state is an empty array [])
            (isEmpty(orderStatus) ? true : orderStatus?.includes(order.order_status)) &&
            (isEmpty(paymentStatus) ? true : paymentStatus?.includes(order.payment_status)) &&
            (isEmpty(fulfillmentStatus) ? true : fulfillmentStatus?.includes(order.fulfillment_status)) &&
            (isEmpty(taggedWith) ? true : order.tags.toLowerCase().includes(taggedWith.toLowerCase()))
        )
      );
    }
  }, [orderStatus, paymentStatus, fulfillmentStatus, taggedWith]);

  const noFiltersSelected = () => {
    return isEmpty(orderStatus) && isEmpty(paymentStatus) && isEmpty(fulfillmentStatus) && isEmpty(taggedWith);
  };

  // remove filter events
  const handleOrderStatusRemove = useCallback(() => setOrderStatus(null), []);
  const handlePaymentStatusRemove = useCallback(() => setPaymentStatus(null), []);
  const handleFulfillmentStatusRemove = useCallback(() => setFulfillmentStatus(null), []);
  const handleTaggedWithRemove = useCallback(() => setTaggedWith(null), []);

  const handleFiltersQueryChange = useCallback((value) => setQueryValue(value), []);

  const handleFiltersClearAll = useCallback(() => {
    handleOrderStatusRemove();
    handlePaymentStatusRemove();
    handleFulfillmentStatusRemove();
    handleTaggedWithRemove();
  }, [handleOrderStatusRemove, handlePaymentStatusRemove, handleFulfillmentStatusRemove, handleTaggedWithRemove]);

  const handleQueryValueRemove = useCallback(() => setQueryValue(null), []);

  // tabs
  const handleTabChange = useCallback((selectedTabIndex) => setSelectedTab(selectedTabIndex), []);

  const tabs = [
    {
      id: "all-orders-1",
      content: "All",
      accessibilityLabel: "All orders",
      panelID: "all-orders-content-1"
    },
    {
      id: "open-orders-1",
      content: "Open",
      accessibilityLabel: "Open orders",
      panelID: "open-orders-content-1"
    },
    {
      id: "unfulfilled-and-partially-fulfilled-orders-1",
      content: "Unfulfilled and partially fulfilled",
      accessibilityLabel: "Unfulfilled and partially fulfilled orders",
      panelID: "unfulfilled-and-partially-fulfilled-orders-content-1"
    },
    {
      id: "unpaid-orders-1",
      content: "Unpaid",
      accessibilityLabel: "Unpaid orders",
      panelID: "unpaid-orders-content-1"
    }
  ];

  // headings for orders table - replaces default heading
  const handleHeadingChange = useCallback((newChange) => {
    setHeadingChecked(newChange);

    if (newChange) {
      setSelectedItems("All");
    } else {
      setSelectedItems([]);
    }
  }, []);

  // bulk actions
  // TO-DO: implement bulk actions to ResourceList (currently doesn't use default header)
  const promotedBulkActions = [
    {
      content: "Create shipping labels",
      onAction: () => console.log("TO-DO: implement bulk create shipping labels")
    },
    {
      content: "Fulfill orders",
      onAction: () => console.log("TO-DO: implement bulk fulfill orders")
    },
    {
      content: "Capture payments",
      onAction: () => console.log("TO-DO: implement bulk capture payments")
    }
  ];

  const bulkActions = [
    {
      content: "Print packing slips",
      onAction: () => console.log("TO-DO: implement bulk print packing slips")
    },
    {
      content: "Archive orders",
      onAction: () => console.log("TO-DO: implement bulk archive orders")
    },
    {
      content: "Unarchive orders",
      onAction: () => console.log("TO-DO: implement bulk unarchive orders")
    },
    {
      content: "Add tags",
      onAction: () => console.log("TO-DO: implement bulk add tags")
    },
    {
      content: "Remove tags",
      onAction: () => console.log("TO-DO: implement bulk remove tags")
    }
  ];

  // sort button - event handler when option is selected in the popover
  const handleSortOptionChange = useCallback(
    (value) => {
      setSortOptionSelected(value);

      if (value[0] === "dateNewest") {
        const sortedData = orderData.sort((a, b) => new Date(b.date) - new Date(a.date));
        setOrderData(sortedData);
      } else {
        const sortedData = orderData.sort((a, b) => new Date(a.date) - new Date(b.date));
        setOrderData(sortedData);
      }
    },
    [orderData]
  );

  const filters = [
    {
      key: "orderStatus",
      label: "Status",
      filter: (
        <ChoiceList
          title="Status"
          titleHidden
          choices={[
            { label: "Open", value: "open" },
            { label: "Archived", value: "archived" },
            { label: "Canceled", value: "canceled" }
          ]}
          selected={orderStatus || []}
          onChange={handleOrderStatusChange}
        />
      ),
      shortcut: true
    },
    {
      key: "paymentStatus",
      label: "Payment status",
      filter: (
        <ChoiceList
          title="Payment status"
          titleHidden
          choices={[
            { label: "Authorized", value: "authorized" },
            { label: "Paid", value: "paid" },
            { label: "Partially refunded", value: "partially refunded" },
            { label: "Partially paid", value: "partially paid" },
            { label: "Pending", value: "pending" },
            { label: "Refunded", value: "refunded" },
            { label: "Unpaid", value: "unpaid" },
            { label: "Voided", value: "voided" }
          ]}
          selected={paymentStatus || []}
          onChange={handlePaymentStatusChange}
          allowMultiple
        />
      ),
      shortcut: true
    },
    {
      key: "fulfillmentStatus",
      label: "Fulfillment status",
      filter: (
        <ChoiceList
          title="Fulfillment status"
          titleHidden
          choices={[
            { label: "Fulfilled", value: "fulfilled" },
            { label: "Unfulfilled", value: "unfulfilled" },
            { label: "Partially fulfilled", value: "partially fulfilled" },
            { label: "Scheduled", value: "scheduled" }
          ]}
          selected={fulfillmentStatus || []}
          onChange={handleFulfillmentStatusChange}
          allowMultiple
        />
      ),
      shortcut: true
    },
    {
      key: "taggedWith",
      label: "Tagged with",
      filter: <TextField label="Tagged with" value={taggedWith} onChange={handleTaggedWithChange} labelHidden />
    }
  ];

  const appliedFilters = [];

  if (!isEmpty(orderStatus)) {
    const key = "orderStatus";
    appliedFilters.push({
      key,
      label: disambiguateLabel(key, orderStatus),
      onRemove: handleOrderStatusRemove
    });
  }

  if (!isEmpty(paymentStatus)) {
    const key = "paymentStatus";
    appliedFilters.push({
      key,
      label: disambiguateLabel(key, paymentStatus),
      onRemove: handlePaymentStatusRemove
    });
  }

  if (!isEmpty(fulfillmentStatus)) {
    const key = "fulfillmentStatus";
    appliedFilters.push({
      key,
      label: disambiguateLabel(key, fulfillmentStatus),
      onRemove: handleFulfillmentStatusRemove
    });
  }

  if (!isEmpty(taggedWith)) {
    const key = "taggedWith";
    appliedFilters.push({
      key,
      label: disambiguateLabel(key, taggedWith),
      onRemove: handleTaggedWithRemove
    });
  }

  // sort button popover
  const toggleSortPopoverActive = useCallback(
    () => setSortPopoverActive((sortPopoverActive) => !sortPopoverActive),
    []
  );

  const sortActivator = (
    <Button icon={SortMinor} onClick={toggleSortPopoverActive}>
      Sort
    </Button>
  );

  const filterControl = (
    <>
      <Filters
        queryValue={queryValue}
        filters={filters}
        appliedFilters={appliedFilters}
        onQueryChange={handleFiltersQueryChange}
        onQueryClear={handleQueryValueRemove}
        onClearAll={handleFiltersClearAll}
      >
        <span className="filters__saved-btn">
          <Button icon={StarFilledMinor} onClick={() => console.log("New filter saved")}>
            Save
          </Button>
        </span>
        <span>
          <Popover active={sortPopoverActive} activator={sortActivator} onClose={toggleSortPopoverActive}>
            <div className="sortPopover">
              <ChoiceList
                title="Sort by"
                choices={[
                  { label: "Date (oldest first)", value: "dateOldest" },
                  { label: "Date (newest first)", value: "dateNewest" }
                ]}
                selected={sortOptionSelected}
                onChange={handleSortOptionChange}
              />
            </div>
          </Popover>
        </span>
      </Filters>
      <div style={{ padding: "1.2rem 2rem 1.2rem 0.8rem" }}>
        <Stack distribution="equalSpacing" alignment="center">
          <Stack.Item>
            <Checkbox label="" checked={headingChecked} onChange={handleHeadingChange} />
          </Stack.Item>
          <Stack.Item fill>
            <Stack distribution="fillEvenly" wrap={false}>
              <TextStyle variation="strong">Order</TextStyle>
              <TextStyle variation="strong">Date</TextStyle>
              <TextStyle variation="strong">Customer</TextStyle>
              <TextStyle variation="strong">Payment</TextStyle>
              <TextStyle variation="strong">Fulfillment</TextStyle>
              <Stack.Item>
                <div style={{ textAlign: "right" }}>
                  <TextStyle variation="strong">Total</TextStyle>
                </div>
              </Stack.Item>
            </Stack>
          </Stack.Item>
        </Stack>
      </div>
    </>
  );

  function disambiguateLabel(key, value) {
    switch (key) {
      case "orderStatus":
        return `${value[0].charAt(0).toUpperCase()}${value[0].slice(1)} orders`;
      case "paymentStatus":
        return value.map((val) => `Payment ${val}`).join(", ");
      case "fulfillmentStatus":
        return value.map((val) => `${val.charAt(0).toUpperCase()}${val.slice(1)}`).join(", ");
      case "taggedWith":
        return `Tagged with ${value}`;
      default:
        return value;
    }
  }

  function isEmpty(value) {
    if (Array.isArray(value)) {
      return value.length === 0;
    } else {
      return value === "" || value == null;
    }
  }

  function formatMoney(amount) {
    return `$${amount / 100}`;
  }

  return (
    <Page
      fullWidth
      title="Orders"
      primaryAction={{ content: "Create order" }}
      secondaryActions={[{ content: "Export", icon: ExportMinor }]}
      actionGroups={[
        {
          title: "More actions",
          accessibilityLabel: "More actions label",
          actions: [
            {
              content: "View",
              disabled: true
            }
          ]
        }
      ]}
    >
      <Layout>
        <Layout.Section>
          <Card>
            <div>
              {/* TO-DO: figure out how to integrate this button into the Tabs component */}
              {/*<div className="all-locations__button">
                <Button icon={LocationsMinor}>All locations</Button>
              </div>*/}
              <Tabs tabs={tabs} selected={selectedTab} onSelect={handleTabChange}>
                <ResourceList
                  resourceName={{ singular: "order", plural: "orders" }}
                  items={orderData}
                  selectedItems={selectedItems}
                  onSelectionChange={setSelectedItems}
                  selectable
                  filterControl={filterControl}
                  //promotedBulkActions={promotedBulkActions}
                  //bulkActions={bulkActions}
                  renderItem={(item) => {
                    const { id, url, order_number, date, customer, payment_status, fulfillment_status, total } = item;
                    return (
                      <ResourceItem
                        id={id}
                        url={url}
                        accessibilityLabel={`View details for ${order_number}`}
                        name={order_number}
                      >
                        <Stack distribution="fillEvenly" wrap={false}>
                          <TextStyle variation="strong">{`#${order_number}`}</TextStyle>
                          <TextStyle>{date}</TextStyle>
                          <TextStyle>{customer}</TextStyle>

                          {payment_status === "paid" ? (
                            <Badge progress="complete">Paid</Badge>
                          ) : (
                            <Badge progress="incomplete">
                              {payment_status[0].toUpperCase()}
                              {payment_status.slice(1).toLowerCase()}
                            </Badge>
                          )}

                          {fulfillment_status === "fulfilled" ? (
                            <Badge progress="complete">Fulfilled</Badge>
                          ) : (
                            <Badge progress="incomplete" status="attention">
                              {fulfillment_status[0].toUpperCase()}
                              {fulfillment_status.slice(1).toLowerCase()}
                            </Badge>
                          )}

                          <Stack.Item>
                            <div style={{ textAlign: "right" }}>
                              <TextStyle>{formatMoney(total)}</TextStyle>
                            </div>
                          </Stack.Item>
                        </Stack>
                      </ResourceItem>
                    );
                  }}
                />
              </Tabs>
            </div>
          </Card>
        </Layout.Section>
      </Layout>
    </Page>
  );
}

export default Orders;
