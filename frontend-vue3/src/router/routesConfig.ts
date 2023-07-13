import { RouteRecordRaw } from "vue-router";
import emptyLayout from "../layouts/emptyLayout.vue";
import mainLayout from "../layouts/mainLayout.vue";
/*
use customLayout on
meta: {
  layout: customLayout
}
#customLayout is a vue component of layouts/folder
*/
const routesConfig = {
  Init: {
    path: "/",
    name: "init",
    component: () => import("../pages/InitPage.vue"),
  },
  Client: {
    path: "/client",
    name: "client",
    component: () => import("../pages/ClientPage.vue"),
    meta: {
      layout: mainLayout,
    },
  },
  Sale: {
    path: "/sale",
    name: "sale",
    component: () => import("../pages/SalePage.vue"),
    meta: {
      layout: mainLayout,
    },
  },
};

const routesList = Object.values(routesConfig);

const routes = routesList.map((route: RouteRecordRaw) => {
  if (!route.meta?.layout) {
    route.meta = Object.assign({}, route.meta, { layout: emptyLayout });
  }
  return route;
});

export { routes, routesConfig, routesList };
