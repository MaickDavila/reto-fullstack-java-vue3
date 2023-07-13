import axios from "../../../modules/axios";
import { ISale } from "../@saleModel";

const getSales = async (date: string[]): Promise<ISale[] | null> => {
  try {
    const newDate = Object.assign([], date);
    if (date.length === 1) newDate.push(date[0]);
    const { data } = await axios.get(`sales/date`, {
      params: {
        startDate: newDate[0],
        endDate: newDate[1],
      },
    });
    return data as ISale[];
  } catch (error) {
    return null;
  }
};

export default getSales;
