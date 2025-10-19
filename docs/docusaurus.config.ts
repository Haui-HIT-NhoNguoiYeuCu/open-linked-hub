import { themes as prismThemes } from "prism-react-renderer";
import type { Config } from "@docusaurus/types";
import type * as Preset from "@docusaurus/preset-classic";

const config: Config = {
  // 💡 CẬP NHẬT THÔNG TIN DỰ ÁN CỦA BẠN
  title: "OpenLinkedHub",
  tagline: "Hệ thống chia sẻ dữ liệu mở liên kết",
  favicon: "img/favicon.ico", // Nhớ tạo file này trong `static/img`

  url: "https://your-github-username.github.io", // Thay bằng URL trang của bạn
  baseUrl: "/open-linked-hub/", // Tên repo của bạn

  organizationName: "your-github-username", // Tên user/tổ chức GitHub
  projectName: "open-linked-hub", // Tên repo

  onBrokenLinks: "throw",
  i18n: {
    defaultLocale: "vi", // Đặt tiếng Việt làm mặc định
    locales: ["vi"],
  },

  presets: [
    [
      "classic",
      {
        // 🔌 BƯỚC 1: TẮT DOCS MẶC ĐỊNH TRONG PRESETS
        docs: false,
        blog: false,
        theme: {
          customCss: "./src/css/custom.css",
        },
      } satisfies Preset.Options,
    ],
  ],

  // 🔌 BƯỚC 2: KHAI BÁO CÁC PHIÊN BẢN DOCS PLUGIN
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
    image: "img/social-card.jpg", // Tạo file này trong `static/img`
    colorMode: {
      respectPrefersColorScheme: true,
    },
    // 🔌 BƯỚC 3: CẬP NHẬT THANH ĐIỀU HƯỚNG (NAVBAR)
    navbar: {
      title: "OpenLinkedHub",
      logo: {
        alt: "OpenLinkedHub Logo",
        src: "img/logo.svg", // Tạo file này trong `static/img`
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
          href: "https://github.com/your-github-username/open-linked-hub", // Thay bằng link repo
          label: "GitHub",
          position: "right",
        },
      ],
    },
    // footer: {
    //   style: "dark",
    //   links: [
    //     // Bạn có thể tùy chỉnh các link ở footer tại đây
    //   ],
    //   copyright: `Copyright © ${new Date().getFullYear()} OpenLinkedHub Project. Built with Docusaurus.`,
    // },
    // prism: {
    //   theme: prismThemes.github,
    //   darkTheme: prismThemes.dracula,
    // },
  } satisfies Preset.ThemeConfig,
};

export default config;
