import React from "react";
import Header from "./Header";
import Footer from "./Footer";
import imgPath from "../assets/img/1.png";
const Intro = () => {
  return (
    <>
      <Header />
      <div
        style={{
          marginTop: "126px",
          paddingBottom: "126px",
          backgroundColor: "white",
        }}
        className="tb_work_wrapper pb20"
      >
        <div className="container">
          <div className="row">
            <div className="col-md-6 col-lg-6 col-sm-6 col-xs-12">
              <div className="tb_work_txt_wrapper">
                <div className="abt_txt_box">
                  <div className="tb_left_heading_wraper">
                    <h4>Giải pháp quản lý tòa nhà văn phòng</h4>
                    <h3>Hệ thống quản lý tòa nhà version 1.0.1</h3>
                    <h2>
                      <span></span>
                    </h2>
                  </div>
                  <p>
                    Hệ thống cho phép admin có thể quản lý các công ty thuê văn
                    phòng trong tòa nhà cũng như thông tin về các mặt bằng mà
                    công ty đó thuê, quản lý các dịch vụ trong tòa nhà và các
                    nhân viên tòa nhà
                  </p>
                </div>
              </div>
            </div>
          </div>
          <div className="row" style={{ marginTop: "28px" }}>
            <div className="col-md-10 col-lg-10 col-sm-10 col-xs-12">
              <div className="tb_work_txt_wrapper">
                <div className="abt_txt_box">
                  <p style={{ fontSize: "20px" }}>
                    Là một công ty công nghệ, MANAGEMENTBUILDING tự hào là đơn
                    vị tiên phongcung cấp các giảI pháp phần mềm trong lĩnh vực
                    bất động sản, áp dụng các công nghệ hiện địa trong xây dựng
                    sản phẩm đảm bảo khả năng tương thích và kết nối với các hệ
                    thống khác của doanh nghiệp.
                  </p>
                </div>
              </div>
            </div>
          </div>

          <div className="row" style={{ marginTop: "28px" }}>
            <div className="col-md-10 col-lg-10 col-sm-10 col-xs-12">
              <div className="tb_work_txt_wrapper">
                <div className="abt_txt_box">
                  <p style={{ fontSize: "20px" }}>
                    Các giải pháp của MANAGEMENTBUILDING bao gồm:
                  </p>
                  <p style={{}}>
                    - Phần mềm quản lý tòa nhà chung cư Building Care.
                  </p>
                  <p style={{}}>
                    - Phần mềm quản lý giao dịch bất động sản Proptech-S.
                  </p>
                  <p style={{}}>
                    - Phần mềm chăm sóc khách hàng bất động sản SPC.
                  </p>
                  <p style={{}}>
                    - Phần mềm điều khiển thiết bị nhà thông minh Smart Life.
                  </p>
                  <p style={{}}>- Phần mềm chat nội bộ doanh nghiệp Chatto.</p>
                </div>
              </div>
            </div>
          </div>

          <div className="row" style={{ marginTop: "36px" }}>
            <div
              className="row"
              style={{
                margin: "36px 0px",
                width: "100%",
                display: "flex",
                justifyContent: "center",
              }}
            >
              <h2>DỰ ÁN ĐÃ TRIỂN KHAI</h2>
            </div>
            <div className="col-md-10 col-lg-10 col-sm-10 col-xs-12 r">
              <div className="tb_work_txt_wrapper row">
                <div className="col-md-6 col-lg-6 col-sm-6 col-xs-12">
                  <div className="">
                    <img
                      src={imgPath}
                      alt=""
                      className=""
                      style={{ backgroundSize: "cover" }}
                    />
                  </div>
                </div>
                <div className="col-md-6 col-lg-6 col-sm-6 col-xs-12">
                  <h4 style={{ fontSize: "20px" }}>Dự án Opal Boulevard</h4>
                  <p style={{}}>
                    Địa chỉ: Mặt tiền Đại Lộ Phạm Văn Đồng, Phường An Bình, Thị
                    Xã Dĩ An, Bình Dương
                  </p>
                  <p style={{}}>Quy mô: 4 block căn hộ với gần 1500 cân</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default Intro;
