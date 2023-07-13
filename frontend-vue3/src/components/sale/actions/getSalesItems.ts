import axios from "../../../modules/axios";
import { ISaleItem } from "../@saleModel";

const getSalesItems = async (saleId: number) => {
  try {
    const { data } = await axios.get(`sale-items/sale/${saleId}`);
    return data as ISaleItem;
  } catch (error) {
    return null;
  }
};

export default getSalesItems;
