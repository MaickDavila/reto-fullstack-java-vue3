<script setup lang="ts">
import { ISale } from "./@saleModel";
import getSales from "./actions/getSales";
import useSaleStore from "./saleStore";
import { castToMoneyFormat } from "../../utils/utils";

const salesData = ref<ISale[] | null>([]);
const date = ref<string[]>([]);

const showDetails = (sale: ISale) => {
  useSaleStore.saleSelected = sale;
  useSaleStore.openDialog = true;
};

const setDateNow = (): void => {
  const currentDate = new Date();
  const year = currentDate.getFullYear();
  const month = String(currentDate.getMonth() + 1).padStart(2, "0");
  const day = String(currentDate.getDate()).padStart(2, "0");
  date.value = [`${year}-${month}-${day}`];
};

const setData = async () => {
  salesData.value = await getSales(date.value);
};

onMounted(() => {
  setDateNow();
  setData();
});
</script>

<template>
  <div class="lg:w-[40%] m-auto flex flex-col gap-5 text-white">
    <span class="text-2xl font-semibold font-quicksand"
      >Lista de Todas las ventas</span
    >

    <div class="flex items-center justify-between">
      <div></div>
      <div class="flex gap-3">
        <el-date-picker
          v-model="date"
          type="daterange"
          range-separator="To"
          start-placeholder="Desde"
          end-placeholder="Hasta"
          format="DD-MM-YYYY"
          value-format="YYYY-MM-DD"
          @change="setData"
        />

        <el-button>Buscar</el-button>
      </div>
    </div>

    <div class="p-2 h-96 overflow-auto">
      <el-table
        :data="salesData"
        bordered
        rowKey="id"
        class="rounded w-full"
        style="width: 100%"
      >
        <el-table-column label="Cliente" prop="client.names" min-width="100px">
          <template #default="{ row }">
            <div class="w-full truncate">
              {{ `${row.client.names} ${row.client.last_names}` }}
            </div>
          </template>
        </el-table-column>
        <el-table-column
          label="Fecha"
          prop="date"
          min-width="100px"
          sortable
        ></el-table-column>

        <el-table-column label="Total" prop="total" min-width="100px" sortable>
          <template #default="{ row }"
            >{{ castToMoneyFormat(row.total) }}
          </template>
        </el-table-column>

        <el-table-column type="options" label="Ver detalle" min-width="100px">
          <template #default="{ row }">
            <el-button @click="showDetails(row)" color="#1E3A8A">
              Ver detalle
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <sale-detail v-if="useSaleStore.openDialog" />
  </div>
</template>
