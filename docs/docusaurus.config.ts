import { themes as prismThemes } from "prism-react-renderer";
import type { Config } from "@docusaurus/types";
import type * as Preset from "@docusaurus/preset-classic";

const config: Config = {
  title: "OpenLinkedHub",
  tagline: "Hệ thống chia sẻ thông tin nguồn mở OpenLinkedHub",
  favicon: "img/favicon.ico",

  // URL chính của trang GitHub Pages
  url: "https://Haui-HIT-NhoNguoiYeuCu.github.io",
  // Đường dẫn cơ sở
  baseUrl: "/open-linked-hub/",

  // Tên tổ chức trên GitHub
  organizationName: "Haui-HIT-NhoNguoiYeuCu",
  // Tên repo
  projectName: "open-linked-hub",

  onBrokenLinks: "throw",
  i18n: {
    defaultLocale: "vi",
    locales: ["vi"],
  },

  presets: [
    [
      "classic",
      {
        docs: false,
        blog: false,
        theme: {
          customCss: "./src/css/custom.css",
        },
      } satisfies Preset.Options,
    ],
  ],

  plugins: [
    [
      "@docusaurus/plugin-content-docs",
      {
        id: "overview",
        path: "overview-docs",
        routeBasePath: "overview",
        sidebarPath: "./sidebarsOverview.ts",
      },
    ],
    [
      "@docusaurus/plugin-content-docs",
      {
        id: "backend",
        path: "backend-docs",
        routeBasePath: "backend",
        sidebarPath: "./sidebarsBackend.ts",
      },
    ],
    [
      "@docusaurus/plugin-content-docs",
      {
        id: "frontend",
        path: "frontend-docs",
        routeBasePath: "frontend",
        sidebarPath: "./sidebarsFrontend.ts",
      },
    ],
    [
      "@docusaurus/plugin-content-docs",
      {
        id: "ml-ai",
        path: "ml-ai-docs",
        routeBasePath: "ml-ai",
        sidebarPath: "./sidebarsMlAi.ts",
      },
    ],
    [
      "@docusaurus/plugin-content-docs",
      {
        id: "infrastructure",
        path: "infrastructure-docs",
        routeBasePath: "infrastructure",
        sidebarPath: "./sidebarsInfrastructure.ts",
      },
    ],
  ],

  themeConfig: {
    image: "img/social-card.jpg",
    colorMode: {
      respectPrefersColorScheme: true,
    },
    navbar: {
      title: "OpenLinkedHub",
      logo: {
        alt: "OpenLinkedHub Logo",
        src: "img/logo.svg",
      },
      items: [
        {
          to: "/overview/intro",
          label: "System Overview",
          position: "left",
          activeBaseRegex: `/overview/`,
        },
        {
          to: "/backend/intro",
          label: "Backend",
          position: "left",
          activeBaseRegex: `/backend/`,
        },
        {
          to: "/frontend/intro",
          label: "Frontend",
          position: "left",
          activeBaseRegex: `/frontend/`,
        },
        {
          to: "/ml-ai/intro",
          label: "ML/AI",
          position: "left",
          activeBaseRegex: `/ml-ai/`,
        },
        {
          to: "/infrastructure/intro",
          label: "Infrastructure",
          position: "left",
          activeBaseRegex: `/infrastructure/`,
        },
        {
          href: "https://github.com/Haui-HIT-NhoNguoiYeuCu/open-linked-hub",
          label: "GitHub",
          position: "right",
        },
      ],
    },
    // footer: {
    //   style: "dark",
    //   links: [
    //   ],
    //   copyright: `Copyright © ${new Date().getFullYear()} OpenLinkedHub Project. Built with Docusaurus.`,
    // },
    prism: {
      theme: prismThemes.github,
      darkTheme: prismThemes.dracula,
    },
  } satisfies Preset.ThemeConfig,
};

export default config;
