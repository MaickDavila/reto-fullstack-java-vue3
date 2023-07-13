<script setup lang="ts">
import type { PropType } from "vue";

import { ISale } from "../@saleModel";

defineProps({
  saleSelected: {
    type: Object as PropType<ISale>,
    required: true,
  },
});
</script>

<template>
  <div class="flex flex-col gap-5">
    <div>
      <span class="text-lg font-semibold">Cliente</span>
    </div>

    <el-form ref="form" label-width="80px">
      <div class="flex flex-col lg:flex-row">
        <el-form-item class="w-full" label="Nombres">
          <el-input readonly v-model="saleSelected.client.names"></el-input>
        </el-form-item>

        <el-form-item label="Apellidos" class="w-full">
          <el-input
            readonly
            v-model="saleSelected.client.last_names"
          ></el-input>
        </el-form-item>

        <el-form-item label="Dni" class="w-full">
          <el-input readonly v-model="saleSelected.client.dni"></el-input>
        </el-form-item>
      </div>

      <div class="flex items-center">
        <el-form-item class="w-full" label="Teléfono">
          <el-input readonly v-model="saleSelected.client.phone"></el-input>
        </el-form-item>

        <el-form-item label="Email" class="w-full">
          <el-input readonly v-model="saleSelected.client.email"></el-input>
        </el-form-item>
      </div>
    </el-form>
  </div>
</template>
