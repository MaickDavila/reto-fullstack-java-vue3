import { IClient } from "../client/clientModel";

export interface IProduct {
  id: number;
  name: string;
  price: number;
}

export interface ISale {
  id: number;
  client: IClient;
  date: Date;
  total: number;
}

export interface ISaleItem {
  id: number;
  saleId: ISale;
  productId: IProduct;
  quantity: number;
}
