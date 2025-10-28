import React from 'react'
import clsx from 'clsx'
import Link from '@docusaurus/Link'
import useDocusaurusContext from '@docusaurus/useDocusaurusContext'
import Layout from '@theme/Layout'
import HomepageFeatures from '@site/src/components/HomepageFeatures'
import HomepageBenefits from '@site/src/components/HomepageBenefits'


import styles from './index.module.css'

interface SiteConfig {
  title: string
  tagline: string
}

interface DocusaurusContext {
  siteConfig: SiteConfig
}

const HeroSplitSection: React.FC = () => {
  return (
    <section className={styles.splitSection}>
      <div className={styles.techBg}></div>
      <div className="container">
        <div className={styles.splitInner}>
          <div className={styles.splitLeft}>
            <h2 className={styles.splitHeading}>Cầu nối tin cậy cho dữ liệu mở</h2>
            <p className={styles.splitText}>
              OpenLinkedHub là nền tảng dữ liệu mở được xây dựng theo kiến trúc microservices, giúp bạn chuẩn hóa,
              liên kết và cung cấp dữ liệu qua API một cách dễ dàng.
            </p>
            <div className={styles.splitButtons}>
              <Link className={clsx('button', styles.smallPrimary)} to="/overview/intro">
                Khám phá ngay
              </Link>
            </div>
            <div className={styles.statsRow}>
              <div className={styles.statItem}>
                <div className={styles.statNumber}>100%</div>
                <div className={styles.statLabel}>Mở và miễn phí</div>
              </div>
              <div className={styles.statItem}>
                <div className={styles.statNumber}>API</div>
                <div className={styles.statLabel}>RESTful & GraphQL</div>
              </div>
              <div className={styles.statItem}>
                <div className={styles.statNumber}>24/7</div>
                <div className={styles.statLabel}>Hỗ trợ liên tục</div>
              </div>
            </div>
          </div>


            <div className={styles.splitRight}>
              <div className={styles.codeCard}>
                <div className={styles.cardHeader}>
                  <div className={styles.circles}>
                    <span></span>
                    <span></span>
                    <span></span>
                  </div>
                  <div className={styles.cardTitle}>Terminal</div>
                </div>
                <div className={styles.cardBody}>
                  <div className={styles.promptLine}>
                    <span className={styles.prompt}>$</span>
                    <span className={styles.command}> curl https://api.openlinkedhub.io/data</span>
                  </div>
                  <pre className={styles.response}>
            {`           {
              "status": "success",
              "data": [{
                "id": "dataset-001",
                "name": "Open Data Hub",
                "records": 1000000
              }]
            }`}
                  </pre>
                </div>
              </div>
            </div>
          </div>
        </div>

    </section>
  )
}

const Home: React.FC = () => {
  const { siteConfig } = useDocusaurusContext() as { siteConfig: SiteConfig }
  return (
    <Layout
      title={`${siteConfig.title} - Nền tảng dữ liệu mở`}
      description="OpenLinkedHub: Nền tảng dữ liệu mở với kiến trúc microservices, chuẩn hóa và liên kết dữ liệu qua API"
    >
      <div className={styles.pageWrapper}>
        <main>
          <HeroSplitSection />
          <HomepageFeatures />
          <HomepageBenefits />
        </main>
      </div>
    </Layout>
  )
}

export default Home