<script setup lang="ts">
import useSaleStore from "../saleStore";
import getSalesItems from "../actions/getSalesItems";
import { castToMoneyFormat } from "../../../utils/utils";

const visible = computed({
  get() {
    return useSaleStore.openDialog;
  },
  set(value: boolean) {
    useSaleStore.openDialog = value;
  },
});

const saleDetailsData = ref();

const saleSelected = computed(() => useSaleStore.saleSelected);

onMounted(async () => {
  saleDetailsData.value = await getSalesItems(saleSelected.value.id);
});
</script>

<template>
  <el-dialog class="customDialog" title="Detalle de la venta" v-model="visible">
    <client-form
      class="bg-blue-50 p-4 rounded-lg"
      :sale-selected="saleSelected"
    />

    <sale-detail-table class="mt-10" :details-data="saleDetailsData" />

    <div
      class="flex items-center justify-between rounded-lg gap-5 mt-10 bg-blue-500 text-white px-5 font-bold font-roboto text-lg"
    >
      <span>
        <i class="fas fa-calendar mr-2" />
        {{ saleSelected.date }}
      </span>

      <span>Total: {{ castToMoneyFormat(saleSelected.total) }} </span>
    </div>
  </el-dialog>
</template>

<style>
.customDialog {
  @apply w-[90%] lg:w-[40%] rounded-xl;
}
</style>
