import axios from "../../modules/axios";
import { IClient } from "./clientModel";

const getClients = async (): Promise<IClient[] | null> => {
  try {
    const { data } = await axios.get("clients");
    return data as IClient[];
  } catch (error) {
    console.error(error);
    return null;
  }
};

export default getClients;
