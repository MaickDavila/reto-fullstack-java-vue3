export const castToMoneyFormat = (value: string | number) => {
  return Number(value).toLocaleString("es-PE", {
    style: "currency",
    currency: "PEN",
  });
};
