<script setup lang="ts">
import getClients from "./getClients";

const clientData = ref();

onMounted(async () => {
  clientData.value = await getClients();
});
</script>

<template>
  <div class="lg:w-[40%] m-auto flex flex-col gap-5 text-white">
    <span class="text-2xl font-semibold font-quicksand"
      >Lista de Todos los Clientes</span
    >

    <div class="h-96 overflow-auto">
      <el-table
        :data="clientData"
        :scroll="{ x: 1200 }"
        bordered
        rowKey="id"
        class="rounded"
        style="width: 100%"
      >
        <el-table-column label="Nombres" prop="names"></el-table-column>
        <el-table-column label="Apellidos" prop="last_names"></el-table-column>
        <el-table-column label="Dni" prop="dni" width="100px"></el-table-column>
        <el-table-column label="Teléfono" prop="phone"></el-table-column>
        <el-table-column label="Correo Electrónico" prop="email">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>
