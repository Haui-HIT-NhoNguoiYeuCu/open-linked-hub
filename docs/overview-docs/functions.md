---
sidebar_position: 2
title: Chức Năng Chính
---

OpenLinkedHub được xây dựng với một bộ tính năng toàn diện, đáp ứng nhu cầu từ quản lý, tìm kiếm, đến tích hợp và bảo mật dữ liệu.

---

### 1. Quản lý Dữ liệu (Data Management)

- **Đăng ký & Xuất bản dữ liệu:** Người dùng có thể tải lên các bộ dữ liệu (`dataset`) với nhiều định dạng (`CSV`, `JSON`, `GeoJSON`, `Parquet`…), đồng thời định nghĩa lược đồ (schema) và quản lý các phiên bản.
- **Kiểm tra chất lượng tự động:** Hệ thống tự động xác thực dữ liệu đầu vào bằng các chuẩn như `JSON Schema` hoặc `Frictionless Data`, giúp phát hiện sớm lỗi định dạng, giá trị thiếu, hoặc tọa độ không hợp lệ.
- **Quản lý phiên bản (Versioning):** Mọi thay đổi trên `dataset` đều được lưu vết, cho phép người dùng dễ dàng khôi phục các phiên bản cũ hoặc so sánh sự khác biệt.

### 2. Siêu dữ liệu & Tìm kiếm (Metadata & Search)

- **Chuẩn hóa siêu dữ liệu:** Hệ thống tuân thủ nghiêm ngặt các tiêu chuẩn quốc tế như `DCAT` và `Schema.org` để mô tả dữ liệu, đảm bảo tính nhất quán và dễ dàng chia sẻ (tiêu đề, chủ đề, giấy phép, khu vực...).
- **Tìm kiếm nâng cao:** Cung cấp khả năng tìm kiếm mạnh mẽ theo từ khóa, thẻ (tags), giấy phép, nhà cung cấp, phạm vi không gian (`bbox`) hoặc khoảng thời gian (`ISO 8601`).
- **Chỉ mục & Gợi ý:** Tích hợp công cụ tìm kiếm mạnh mẽ hỗ trợ `full-text search`, tự động gợi ý (autocomplete) và lọc kết quả theo nhiều tiêu chí (faceted search).

### 3. Truy xuất & Tích hợp (Access & Integration)

- **API REST & GraphQL:** Cung cấp hai lựa chọn API hiện đại và thống nhất, cho phép người dùng đọc, lọc, và kết hợp dữ liệu một cách linh hoạt.
- **Webhooks/Streaming:** Hỗ trợ đăng ký nhận thông báo theo thời gian thực (real-time) mỗi khi dữ liệu quan tâm có bản cập nhật mới.
- **SDK & Postman:** Đi kèm bộ công cụ phát triển phần mềm (`SDK`) cho `JavaScript`, `Python` và các bộ sưu tập Postman mẫu, giúp nhà phát triển tích hợp vào ứng dụng của họ nhanh nhất có thể.
- **Hỗ trợ không gian & thời gian:** Tối ưu cho dữ liệu địa lý, cho phép truy vấn không gian qua `PostGIS`, xuất dữ liệu `GeoJSON`, và phân tích theo tọa độ hoặc mốc thời gian.

### 4. Liên kết Dữ liệu (Linked Data)

- **Định danh chuẩn:** Cho phép liên kết các bộ dữ liệu khác nhau dựa trên các định danh được chuẩn hóa như mã địa giới hành chính (`ADM`), chuẩn thời gian `ISO 8601`, và các danh mục lĩnh vực.
- **JSON-LD & SPARQL:** Cung cấp tùy chọn xuất dữ liệu dưới dạng `Linked Data` (`JSON-LD`) và một điểm truy cập (`endpoint`) `SPARQL` cho các bài toán truy vấn ngữ nghĩa nâng cao.

### 5. Quản trị & Bảo mật (Governance & Security)

- **Quản lý truy cập:** Tích hợp các phương thức xác thực hiện đại như `OIDC`/`OAuth2` (qua Keycloak) hoặc `API Key` truyền thống, kết hợp với hệ thống phân quyền chi tiết theo vai trò (đọc/ghi/quản trị).
- **Rate Limiting & Giám sát:** Áp dụng cơ chế giới hạn tốc độ truy cập API để đảm bảo sự ổn định của hệ thống. Toàn bộ hoạt động được theo dõi (log & metrics) qua các công cụ như `Prometheus`/`Grafana`.
- **Bảo vệ dữ liệu nhạy cảm:** Cung cấp tính năng ẩn danh hóa các trường chứa thông tin định danh cá nhân (`PII`) để bảo vệ quyền riêng tư.

### 6. Giao diện & Trực quan (Portal & Visualization)

- **Cổng dữ liệu:** Giao diện web thân thiện, cho phép người dùng duyệt, tìm kiếm và xem trước các bộ dữ liệu. Tích hợp sẵn các công cụ trực quan hóa cơ bản như biểu đồ và bản đồ nền.
- **Console truy vấn:** Cung cấp một giao diện tương tác, cho phép người dùng thử nghiệm các câu lệnh truy vấn `REST` hoặc `GraphQL` trực tiếp trên trình duyệt.
- **Hướng dẫn & Tài liệu:** Xây dựng một hệ thống tài liệu đầy đủ, tự động tạo từ `OpenAPI`/`Swagger UI`, kèm theo hướng dẫn sử dụng `SDK` và các quy tắc đóng góp cho cộng đồng.
