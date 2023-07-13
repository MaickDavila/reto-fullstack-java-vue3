<script setup lang="ts">
const router = useRouter();
import { RouteRecordRaw } from "vue-router";
import { routesConfig } from "../router/routesConfig";

const goTo = (route: RouteRecordRaw) => {
  router.push(route);
};
</script>

<template>
  <div class="flex items-center justify-center flex-col p-5">
    <span class="text-2xl font-bold text-blue-900">¿A donde vamos?</span>

    <div class="mt-5 flex">
      <el-button
        color="#1E3A8A"
        @click="goTo(routesConfig.Client)"
        size="large"
        type="primary"
      >
        Clientes
      </el-button>

      <el-button
        color="#1E3A8A"
        @click="goTo(routesConfig.Sale)"
        size="large"
        type="primary"
      >
        Ventas
      </el-button>
    </div>
  </div>
</template>
