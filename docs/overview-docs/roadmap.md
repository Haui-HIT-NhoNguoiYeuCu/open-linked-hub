---
sidebar_position: 3
title: Lộ Trình Phát Triển
---

Lộ trình phát triển của OpenLinkedHub được chia thành nhiều giai đoạn, đi từ việc xây dựng một sản phẩm khả dụng tối thiểu (`MVP`) đến một nền tảng quy mô lớn, sẵn sàng cho sản xuất và tích hợp sâu rộng.

---

### 1. Giai đoạn 1 – Nền tảng MVP (2–3 tháng)

**Mục tiêu:** Ra mắt phiên bản nền tảng đầu tiên, cơ bản nhưng hoàn chỉnh, có thể chạy end-to-end.

- **Chức năng chính:**
  - Nộp & xuất bản `dataset` (`CSV`/`GeoJSON`).
  - Tìm kiếm siêu dữ liệu cơ bản (từ khóa, thẻ).
  - Truy xuất dữ liệu qua `REST API`.
  - Cổng dữ liệu (Portal) hiển thị danh sách `dataset` và bản đồ nền đơn giản.
  - CI/CD cơ bản với `Docker Compose`.
- **Sản phẩm bàn giao:** 5–10 `dataset` mẫu, tài liệu hướng dẫn triển khai 1-click.

---

### 2. Giai đoạn 2 – Mở rộng Tính năng (3–6 tháng)

**Mục tiêu:** Bổ sung các tính năng nâng cao, `SDK` và ứng dụng demo để chứng minh giá trị thực tiễn.

- **Tính năng & Sản phẩm:**
  - Bổ sung `API GraphQL` để hỗ trợ các truy vấn linh hoạt.
  - Phát hành bộ `SDK` (`JavaScript`, `Python`) và `Postman collection` cho nhà phát triển.
  - Nâng cấp chỉ mục tìm kiếm với `OpenSearch`/`Elasticsearch` (hỗ trợ autocomplete, filter nâng cao).
  - Triển khai tính năng quản lý phiên bản dữ liệu và nhật ký thay đổi (`changelog`).
  - Tích hợp xác thực qua `Keycloak` (`OIDC`) và hệ thống phân quyền chi tiết.
  - Xây dựng ứng dụng demo về môi trường (ví dụ: giám sát ngập đô thị).

---

### 3. Giai đoạn 3 – Liên kết Dữ liệu & ML/AI (6–12 tháng)

**Mục tiêu:** Khai thác sức mạnh của Dữ liệu Liên kết (Linked Data) và tích hợp các module học máy thông minh.

- **Tính năng & Sản phẩm:**
  - Hỗ trợ `Linked Data`: xuất dữ liệu định dạng `JSON-LD` và cung cấp `endpoint SPARQL`.
  - Liên kết dữ liệu theo các định danh chuẩn: mã địa giới `ADM`, thời gian `ISO 8601`, danh mục lĩnh vực.
  - Tích hợp Module `ML/AI`:
    - Tự động gắn cờ chất lượng cho dữ liệu từ cảm biến.
    - Phát hiện bất thường và hỗ trợ chuẩn hóa dữ liệu tự động.
    - Gợi ý, bổ sung các thông tin ngữ nghĩa cho dữ liệu.

---

### 4. Giai đoạn 4 – Quy mô lớn & Hạ tầng Sản xuất (12–24 tháng)

**Mục tiêu:** Hoàn thiện hạ tầng để hệ thống có thể hoạt động ổn định, an toàn và có khả năng chịu tải cao.

- **Tính năng & Sản phẩm:**
  - Triển khai trên `Kubernetes` (sử dụng `Helm Chart`, `autoscaling`, `secrets`).
  - Cấu hình High Availability (HA)/Cluster cho `Postgres`, `MinIO`, `Kafka`.
  - Xây dựng hệ thống giám sát và cảnh báo hoàn chỉnh (`Prometheus`, `Grafana`, `ELK`).
  - Ban hành chính sách dữ liệu mở: quy định giấy phép rõ ràng, cơ chế ẩn danh dữ liệu nhạy cảm.
  - Mở rộng cộng đồng: tổ chức `hackathon`, tạo các `good-first-issues`, cung cấp `template` cho `dataset`.

---

### 5. Tầm nhìn Dài hạn (>24 tháng)

**Mục tiêu:** Trở thành một hub dữ liệu mở liên kết chuẩn quốc gia/khu vực, đóng vai trò quan trọng trong hệ sinh thái số.

- **Định hướng:**
  - Tích hợp sâu vào hệ sinh thái chính phủ điện tử và đô thị thông minh.
  - Mở `API` công cộng cho các ứng dụng của bên thứ ba (NGO, doanh nghiệp, startup).
  - Mở rộng ứng dụng sang các lĩnh vực khác như giao thông, nông nghiệp, và y tế.
