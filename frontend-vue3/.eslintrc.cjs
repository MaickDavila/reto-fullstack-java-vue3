module.exports = {
  root: true,
  env: {
    node: true,
  },
  extends: [
    "plugin:vue/vue3-essential",
    "eslint:recommended",
    "@vue/eslint-config-typescript/recommended",
    "@vue/prettier",
    "@vue/prettier/@typescript-eslint",
    "@vue/eslint-config-prettier",
    "./.eslintrc-auto-import.json",
  ],
  rules: {
    // override/add rules settings here, such as:
    // "vue/no-unused-vars": "error",
    "vue/multi-word-component-names": "off",
  },
};
