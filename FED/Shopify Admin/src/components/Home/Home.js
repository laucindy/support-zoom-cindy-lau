import React from "react";
import {
  Badge,
  Button,
  CalloutCard,
  Card,
  Heading,
  Icon,
  Layout,
  Link,
  MediaCard,
  Stack,
  Subheading,
  TextContainer,
  TextStyle,
  VideoThumbnail
} from "@shopify/polaris";
import {
  CaretDownMinor,
  ChevronRightMinor,
  OrdersMajorMonotone,
  StoreMajorMonotone
} from "@shopify/polaris-icons";
import "./Home.scss";

function Home() {
  return (
    <Layout>
      <Layout.Section>
        <div className="main__wrapper">
          <TextContainer>
            <div style={{ padding: "25px 0" }}>
              <TextStyle variation="subdued">
                Here's what's happening with your store today.
              </TextStyle>
            </div>
          </TextContainer>

          <Card sectioned subdued>
            <Stack>
              <div style={{ display: "flex", height: "100%" }}>
                <Icon source={StoreMajorMonotone} color="inkLightest" />
              </div>

              <Stack vertical={true}>
                <TextContainer spacing="tight">
                  <Heading>
                    <TextStyle variation="subdued">No store activity</TextStyle>
                  </Heading>
                  <TextStyle variation="subdued">
                    Your sales, orders, and sessions will show here.
                  </TextStyle>
                </TextContainer>
              </Stack>
            </Stack>
          </Card>

          <Card sectioned>
            <Stack>
              <Stack.Item>
                <Icon source={OrdersMajorMonotone} />
              </Stack.Item>
              <Stack.Item fill>
                <p>
                  <TextStyle variation="strong">1 order</TextStyle> to fulfill
                </p>
              </Stack.Item>
              <Stack.Item>
                <Icon source={ChevronRightMinor} color="skyDark" />
              </Stack.Item>
            </Stack>
          </Card>

          <MediaCard
            title="Start selling gift cards"
            primaryAction={{
              content: "Set up gift cards",
              onAction: () => {}
            }}
            description={`Learn how to setup and start selling gift cards in your online store, today.`}
            popoverActions={[{ content: "Dismiss", onAction: () => {} }]}
          >
            <VideoThumbnail
              videoLength={80}
              thumbnailUrl="https://screenshot.click/21-40-6kqo1-bcuml.jpg"
            />
          </MediaCard>

          <CalloutCard
            title="Customize the style of your checkout"
            illustration="https://cdn.shopify.com/s/assets/admin/checkout/settings-customizecart-705f57c725ac05be5a34ec20c05b94298cb8afd10aac7bd9c7ad02030f48cfa0.svg"
            primaryAction={{
              content: "Customize checkout",
              url: "https://www.shopify.com"
            }}
          >
            <p>Upload your store’s logo, change colors and fonts, and more.</p>
          </CalloutCard>

          <Card title="Add your own domain to strengthen your brand" sectioned>
            <Stack>
              <TextContainer>
                Your current domain is{" "}
                <TextStyle variation="strong">
                  yourstore.myshopify.com
                </TextStyle>
                . Add or buy a custom domain to help customers remember your
                online store.
              </TextContainer>
              <Button>Add domain</Button>
            </Stack>
          </Card>
        </div>
      </Layout.Section>

      <Layout.Section secondary>
        <Card>
          <Card.Section>
            <Stack distribution="fill">
              <Stack.Item>
                <div className="btn__wide">
                  <Button>
                    All channels <Icon source={CaretDownMinor} />
                  </Button>
                </div>
              </Stack.Item>

              <Stack.Item>
                <div className="btn__wide">
                  <Button>
                    Today <Icon source={CaretDownMinor} />
                  </Button>
                </div>
              </Stack.Item>
            </Stack>
          </Card.Section>

          <Card.Section>
            <Stack>
              <Stack.Item fill>
                <Subheading variation="strong">Total sales</Subheading>
              </Stack.Item>
              <Stack.Item>
                <TextStyle variation="subdued">Today</TextStyle>
              </Stack.Item>
            </Stack>
            <TextContainer>
              <TextStyle variation="subdued">
                There were no sales during this time.
              </TextStyle>
            </TextContainer>
          </Card.Section>

          <Card.Section>
            <Stack>
              <Stack.Item fill>
                <Subheading variation="strong">
                  Total sales breakdown
                </Subheading>
              </Stack.Item>
              <Stack.Item>
                <TextStyle variation="subdued">Today</TextStyle>
              </Stack.Item>
            </Stack>
            <TextContainer>
              <TextStyle variation="subdued">
                There were no sales during this time.
              </TextStyle>
            </TextContainer>
          </Card.Section>

          <Card.Section>
            <Stack>
              <Stack.Item fill>
                <Subheading variation="strong">
                  Total sales by channel
                </Subheading>
              </Stack.Item>
              <Stack.Item>
                <TextStyle variation="subdued">Today</TextStyle>
              </Stack.Item>
            </Stack>
            <TextContainer>
              <TextStyle variation="subdued">
                There were no sales during this time.
              </TextStyle>
            </TextContainer>
          </Card.Section>

          <Card.Section>
            <Stack>
              <Stack.Item fill>
                <Subheading variation="strong">Top products</Subheading>
              </Stack.Item>
              <Stack.Item>
                <TextStyle variation="subdued">Today</TextStyle>
              </Stack.Item>
            </Stack>
            <TextContainer>
              <TextStyle variation="subdued">
                There were no products sold during this time.
              </TextStyle>
            </TextContainer>
          </Card.Section>

          <Card.Section subdued title="Payout schedule">
            <div className="payout_schedule">
              <Stack>
                <Stack.Item fill>
                  January 28 <Badge status="success">Paid</Badge>
                </Stack.Item>
                <Stack.Item>$50.04</Stack.Item>
              </Stack>

              <Stack>
                <Stack.Item fill>
                  January 14 <Badge status="success">Paid</Badge>
                </Stack.Item>
                <Stack.Item>$38.23</Stack.Item>
              </Stack>

              <Stack>
                <Stack.Item fill>Balance</Stack.Item>
                <Stack.Item>$0.00</Stack.Item>
              </Stack>
            </div>
          </Card.Section>

          <Card.Section subdued>
            <TextContainer>
              <p>
                <TextStyle variation="subdued">
                  Your next payout is estimated for February 12.
                </TextStyle>
              </p>
              <p>
                <Link url="/">View all payouts</Link>
              </p>
            </TextContainer>
          </Card.Section>

          <Card.Section subdued title="Activity">
            <Stack vertical>
              <TextContainer>
                <p>You enabled storefront password</p>
                <TextStyle variation="subdued">
                  January 18, 2021, 10:42 AM EST
                </TextStyle>
              </TextContainer>

              <TextContainer>
                <p>You disabled storefront password</p>
                <TextStyle variation="subdued">
                  January 18, 2021, 10:07 AM EST
                </TextStyle>
              </TextContainer>

              <TextContainer>
                <p>You added user: Cindy Lau</p>
                <TextStyle variation="subdued">
                  January 3, 2021, 9:17 AM EST
                </TextStyle>
              </TextContainer>

              <Link url="/">View all recent activity</Link>
            </Stack>
          </Card.Section>
        </Card>
      </Layout.Section>
    </Layout>
  );
}

export default Home;
