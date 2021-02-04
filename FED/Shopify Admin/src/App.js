import React, { useCallback, useState } from "react";
import "@shopify/polaris/styles.css";
import { Frame, TopBar, Navigation, Icon } from "@shopify/polaris";
import {
  AnalyticsMajorMonotone,
  AppsMajorMonotone,
  CaretDownMinor,
  CirclePlusMinor,
  CustomersMajorMonotone,
  DiscountsMajorMonotone,
  HomeMajorMonotone,
  MarketingMajorMonotone,
  OnlineStoreMajorMonotone,
  OrdersMajorMonotone,
  ProductsMajorMonotone,
  SettingsMajorMonotone,
  ViewMinor
} from "@shopify/polaris-icons";
import Home from "./components/Home";
import Orders from "./components/Orders";
import Products from "./components/Products";
import "./styles.scss";

function App() {
  const [menuState, setMenuState] = useState("home");
  const setPageMarkup = useCallback((value) => setMenuState(value), []);

  const [isSearchActive, setIsSearchActive] = useState(false);
  const [searchValue, setSearchValue] = useState("");

  const handleSearchChange = useCallback((value) => {
    setSearchValue(value);
    setIsSearchActive(value.length > 0);
  }, []);

  const userMenuMarkup = (
    <TopBar.UserMenu initials="🦄" name="Support Zoom" detail="2020 Cohort" />
  );

  const searchFieldMarkup = (
    <TopBar.SearchField
      placeholder="Search"
      onChange={handleSearchChange}
      value={searchValue}
      showFocusBorder
    />
  );

  const topBarLeftMenu = (
    <div className="TopBar__LeftMenu">
      <img
        src="https://cdn.shopify.com/shopifycloud/web/assets/v1/2217fb04df073033ccce8d125b0ea020.svg"
        alt="Shopify Logo"
        style={{ height: "35px" }}
      />
      <p>Store name here</p>
      <Icon source={CaretDownMinor} color="white" />
    </div>
  );

  const topBarMarkup = (
    <TopBar
      showNavigationToggle
      userMenu={userMenuMarkup}
      searchField={searchFieldMarkup}
      searchResultsVisible={isSearchActive}
      contextControl={topBarLeftMenu}
    />
  );

  const navigationMarkup = (
    <div className="navigation__wrapper">
      <Navigation location="/">
        <Navigation.Section
          separator
          items={[
            {
              label: "Home",
              icon: HomeMajorMonotone,
              url: "/",
              onClick: () => setPageMarkup("home")
            },
            {
              label: "Orders",
              icon: OrdersMajorMonotone,
              badge: "1",
              onClick: () => {
                setPageMarkup("orders");
              },
              subNavigationItems: [
                {
                  url: "/admin/orders",
                  disabled: false,
                  selected: true,
                  label: "All orders"
                },
                {
                  url: "/admin/drafts",
                  disabled: false,
                  selected: false,
                  label: "Drafts"
                },
                {
                  url: "/admin/abandoned_checkouts",
                  disabled: false,
                  selected: false,
                  label: "Abandoned checkouts"
                }
              ]
            },
            {
              label: "Products",
              icon: ProductsMajorMonotone,
              onClick: () => setPageMarkup("products")
            },
            {
              label: "Customers",
              icon: CustomersMajorMonotone,
              onClick: () => setPageMarkup("customers")
            },
            {
              label: "Analytics",
              icon: AnalyticsMajorMonotone,
              onClick: () => setPageMarkup("analytics")
            },
            {
              label: "Marketing",
              icon: MarketingMajorMonotone,
              onClick: () => setPageMarkup("marketing")
            },
            {
              label: "Discounts",
              icon: DiscountsMajorMonotone,
              onClick: () => setPageMarkup("discounts")
            },
            {
              label: "Apps",
              icon: AppsMajorMonotone,
              onClick: () => setPageMarkup("apps")
            }
          ]}
        />
        <Navigation.Section
          title="Sales channels"
          items={[
            {
              url: "/themes",
              label: "Online Store",
              icon: OnlineStoreMajorMonotone,
              secondaryAction: {
                url: "/preview",
                accessibilityLabel: "Preview store",
                icon: ViewMinor
              }
            }
          ]}
          action={{
            accessibilityLabel: "Add sales channel",
            icon: CirclePlusMinor,
            onClick: () => {}
          }}
        />
        <Navigation.Section
          items={[
            {
              label: "Settings",
              icon: SettingsMajorMonotone
            }
          ]}
        />
      </Navigation>
    </div>
  );

  const getCurrentMarkup = () => {
    switch (menuState) {
      case "orders":
        return <Orders />;
      case "products":
        return <Products />;
      default:
        return <Home />;
    }
  };

  return (
    <Frame topBar={topBarMarkup} navigation={navigationMarkup}>
      {getCurrentMarkup()}
    </Frame>
  );
}

export default App;
