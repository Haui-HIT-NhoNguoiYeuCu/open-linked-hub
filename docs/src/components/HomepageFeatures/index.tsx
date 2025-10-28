import type { ReactNode } from "react"
import clsx from "clsx"
import Heading from "@theme/Heading"
import styles from "./styles.module.css"

type FeatureItem = {
  title: string
  icon: string
  description: ReactNode
}

const FeatureList: FeatureItem[] = [
  {
    title: "Chuẩn hóa dữ liệu",
    icon: "📊",
    description: <>Chuyển đổi dữ liệu phân tán thành các định dạng chuẩn, dễ hiểu và có thể tái sử dụng.</>,
  },
  {
    title: "Liên kết thông minh",
    icon: "🔗",
    description: <>Kết nối các nguồn dữ liệu khác nhau thông qua các mối quan hệ có ý nghĩa và có cấu trúc.</>,
  },
  {
    title: "API hiệu suất cao",
    icon: "⚡",
    description: <>Cung cấp dữ liệu qua API RESTful và GraphQL với hiệu suất tối ưu và khả năng mở rộng.</>,
  },
  {
    title: "Kiến trúc Microservices",
    icon: "🏗️",
    description: <>Thiết kế linh hoạt với các dịch vụ độc lập, dễ bảo trì và triển khai.</>,
  },
  {
    title: "Tích hợp dễ dàng",
    icon: "🔌",
    description: <>Tích hợp nhanh chóng vào các ứng dụng hiện có với SDK và tài liệu chi tiết.</>,
  },
  {
    title: "Mã nguồn mở",
    icon: "🌐",
    description: <>Hoàn toàn mã nguồn mở, cho phép cộng đồng đóng góp và cải thiện liên tục.</>,
  },
]

function Feature({ title, icon, description }: FeatureItem) {
  return (
    <div className={clsx("col col--4", styles.featureCol)}>
      <div className={styles.featureCard}>
        <div className={styles.featureIcon}>{icon}</div>
        <Heading as="h3" className={styles.featureTitle}>
          {title}
        </Heading>
        <p className={styles.featureDescription}>{description}</p>
      </div>
    </div>
  )
}

export default function HomepageFeatures(): ReactNode {
  return (
    <section className={styles.features}>
      <div className="container">
        <div className={styles.featuresHeader}>
          <Heading as="h2" className={styles.featuresTitle}>
            Tính năng chính
          </Heading>
          <p className={styles.featuresSubtitle}>
            OpenLinkedHub cung cấp các công cụ mạnh mẽ để quản lý, chuẩn hóa và chia sẻ dữ liệu mở
          </p>
        </div>
        <div className="row">
          {FeatureList.map((props, idx) => (
            <Feature key={idx} {...props} />
          ))}
        </div>
      </div>
    </section>
  )
}
