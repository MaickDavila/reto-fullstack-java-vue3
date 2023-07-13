<template>
  <component :is="$route.meta.layout ? $route.meta.layout : 'div'"></component>
</template>
