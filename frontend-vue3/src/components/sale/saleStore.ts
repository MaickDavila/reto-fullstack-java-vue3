import { ISale } from "./@saleModel";

const state = reactive({
  openDialog: false,
  saleSelected: {} as ISale,
});

const useSaleStore = {
  get openDialog() {
    return state.openDialog;
  },
  set openDialog(value: boolean) {
    state.openDialog = value;
  },

  get saleSelected() {
    return state.saleSelected;
  },
  set saleSelected(sale: ISale) {
    state.saleSelected = sale;
  },
};

export default useSaleStore;
