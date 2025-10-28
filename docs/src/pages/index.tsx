import type { ReactNode } from "react"
import clsx from "clsx"
import Link from "@docusaurus/Link"
import useDocusaurusContext from "@docusaurus/useDocusaurusContext"
import Layout from "@theme/Layout"
import HomepageFeatures from "@site/src/components/HomepageFeatures"
import HomepageBenefits from "@site/src/components/HomepageBenefits"
import HomepageCTA from "@site/src/components/HomepageCTA"
import Heading from "@theme/Heading"

import styles from "./index.module.css"

function HomepageHeader() {
  const { siteConfig } = useDocusaurusContext()
  return (
    <header className={clsx("hero hero--primary", styles.heroBanner)}>
      <div className="container">
        <div className={styles.heroContent}>
          <Heading as="h1" className={styles.heroTitle}>
            {siteConfig.title}
          </Heading>
          <p className={styles.heroSubtitle}>{siteConfig.tagline}</p>
          <p className={styles.heroDescription}>
            Một nền tảng dữ liệu mở được xây dựng theo kiến trúc microservices, trở thành cầu nối tin cậy giữa nguồn dữ
            liệu thô và các ứng dụng có giá trị cho xã hội.
          </p>
          <div className={styles.buttons}>
            <Link className={clsx("button button--lg", styles.buttonPrimary)} to="/overview/intro">
              Bắt đầu khám phá
            </Link>
            <Link
              className={clsx("button button--lg", styles.buttonSecondary)}
              to="https://github.com/Haui-HIT-NhoNguoiYeuCu/open-linked-hub"
              target="_blank"
            >
              Xem trên GitHub
            </Link>
          </div>
        </div>
      </div>
    </header>
  )
}

export default function Home(): ReactNode {
  const { siteConfig } = useDocusaurusContext()
  return (
    <Layout
      title={`${siteConfig.title} - Nền tảng dữ liệu mở`}
      description="OpenLinkedHub: Nền tảng dữ liệu mở với kiến trúc microservices, chuẩn hóa và liên kết dữ liệu qua API"
    >
      <HomepageHeader />
      <main>
        <HomepageFeatures />
        <HomepageBenefits />
        <HomepageCTA />
      </main>
    </Layout>
  )
}