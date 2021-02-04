import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import * as serviceWorker from "./serviceWorker";
import enTranslations from "@shopify/polaris/locales/en.json";
import { AppProvider } from "@shopify/polaris";

const theme = {
  colors: {
    topBar: {
      background: "#1C2260"
    }
  },
  logo: {
    width: 30,
    topBarSource:
      "https://cdn.shopify.com/shopifycloud/web/assets/v1/2217fb04df073033ccce8d125b0ea020.svg",
    url: "https://shopify.com",
    accessibilityLabel: "Shopify"
  }
};

ReactDOM.render(
  <AppProvider theme={theme} i18n={enTranslations}>
    <App />
  </AppProvider>,
  document.getElementById("root")
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
