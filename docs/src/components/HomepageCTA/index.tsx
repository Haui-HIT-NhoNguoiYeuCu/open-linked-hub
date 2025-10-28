import type { ReactNode } from "react"
import clsx from "clsx"
import Link from "@docusaurus/Link"
import Heading from "@theme/Heading"
import styles from "./styles.module.css"

export default function HomepageCTA(): ReactNode {
  return (
    <section className={styles.cta}>
      <div className="container">
        <div className={styles.ctaContent}>
          <Heading as="h2" className={styles.ctaTitle}>
            Sẵn sàng bắt đầu?
          </Heading>
          <p className={styles.ctaDescription}>
            Khám phá tài liệu chi tiết, xem các ví dụ code, và tham gia cộng đồng OpenLinkedHub ngay hôm nay.
          </p>
          <div className={styles.ctaButtons}>
            <Link className={clsx("button button--lg", styles.buttonPrimary)} to="/overview/intro">
              Xem tài liệu
            </Link>
            <Link
              className={clsx("button button--lg", styles.buttonSecondary)}
              to="https://github.com/Haui-HIT-NhoNguoiYeuCu/open-linked-hub"
              target="_blank"
            >
              Truy cập GitHub
            </Link>
          </div>
        </div>
      </div>
    </section>
  )
}