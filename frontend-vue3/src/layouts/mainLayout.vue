<script setup lang="ts">
import { routesConfig } from "../router/routesConfig";
</script>

<template>
  <div class="w-full h-screen flex flex-col items-center bg-blue-900">
    <el-menu
      mode="horizontal"
      router
      :default-active="$route.path"
      class="w-full justify-center items-center"
    >
      <el-menu-item :index="routesConfig.Client.path">Clientes</el-menu-item>
      <el-menu-item :index="routesConfig.Sale.path">Ventas</el-menu-item>

      <el-menu-item :index="routesConfig.Init.path">
        <i class="fa-solid fa-right-from-bracket"></i>
      </el-menu-item>
    </el-menu>

    <main class="w-full p-5 h-adapter">
      <router-view />
    </main>

    <footer class="text-gray-400">Powered by Maick Davila!</footer>
  </div>
</template>

<style>
.h-adapter {
  height: calc(100vh - 80px);
}
</style>
