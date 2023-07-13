<script setup lang="ts">
import { PropType } from "vue";
import { ISaleItem } from "../@saleModel";
import { castToMoneyFormat } from "../../../utils/utils";

defineProps({
  detailsData: {
    type: Array as PropType<Array<ISaleItem>>,
  },
});
</script>

<template>
  <el-table
    :data="detailsData"
    :scroll="{ x: 1200 }"
    bordered
    rowKey="id"
    class="rounded"
    style="width: 100%"
    stripe
  >
    <el-table-column label="Producto" prop="productId.name"></el-table-column>
    <el-table-column label="Precio" prop="productId.price">
      <template #default="{ row }">
        {{ castToMoneyFormat(row.productId.price) }}
      </template>
    </el-table-column>
    <el-table-column label="Cantidad" prop="quantity"></el-table-column>
    <el-table-column label="Subtotal" prop="productId.price">
      <template #default="{ row }">
        {{ castToMoneyFormat(row.productId.price * row.quantity) }}
      </template>
    </el-table-column>
  </el-table>
</template>
