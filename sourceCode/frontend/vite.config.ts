import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import path from "path"

// https://vitejs.dev/config/
export default defineConfig({
  server: {
    port: 8081,
    proxy: {
        '/api': {
            target: 'http://localhost:8081',
            changeOrigin: true,
            rewrite: (path) => path.replace(/^\/api/, '')
        }
    },
    strictPort: true,
    host: true,
    origin: "http://0.0.0.0:8081",
  },
  base: "/",
  plugins: [react()],
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src"),
    },
  },
  preview: {
    port: 8081,
    strictPort: true,
  },
})