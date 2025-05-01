<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giới Thiệu Nhóm</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&family=Open+Sans:wght@300;400;600&display=swap">
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #efebe9;
            color: #4e342e;
            line-height: 1.7;
        }

        .container {
            width: 90%;
            max-width: 900px;
            margin: 10px auto;
            padding: 50px;
            background-color: #ffffff;
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.15);
            border-radius: 15px;
            text-align: center;
        }

        .title-section h2 {
            font-family: 'Merriweather', serif;
            font-size: 40px;
            color: #3e2723;
            margin-bottom: 15px;
            position: relative;
            padding-bottom: 15px;
        }

        .title-section h2::after {
            content: '';
            position: absolute;
            left: 50%;
            bottom: 0;
            transform: translateX(-50%);
            width: 100px;
            height: 5px;
            background-color: #795548;
            border-radius: 3px;
        }

        .title-section h3 {
            font-size: 26px;
            color: #5d4037;
            margin-top: 20px;
            margin-bottom: 30px;
            font-weight: 400;
        }

        .title-section p {
            font-size: 19px;
            color: #6d4c41;
            margin-bottom: 12px;
        }

        .team-members-list {
            list-style: none;
            padding: 0;
            margin-top: 40px;
        }

        .team-members-list li {
            background-color: #f5f5f5;
            padding: 20px 25px;
            margin-bottom: 18px;
            border-radius: 10px;
            text-align: left;
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 19px;
            border-left: 6px solid #a1887f;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.08);
            transition: transform 0.2s ease;
        }

         .team-members-list li:hover {
             transform: translateY(-3px);
         }

        .team-members-list li strong {
            color: #3e2723;
            font-weight: 600;
        }

        .team-members-list li span {
            font-size: 17px;
            color: #795548;
            font-weight: 400;
        }

        .footer {
            margin-top: 50px;
            font-size: 17px;
            color: #8d6e63;
        }

        .start-button {
            display: inline-block;
            width: 280px;
            margin: 50px auto 30px;
            padding: 20px 35px;
            text-align: center;
            background-color: #6d4c41;
            color: white;
            font-size: 22px;
            font-weight: 600;
            border-radius: 35px;
            text-decoration: none;
            transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3);
            border: none;
            cursor: pointer;
        }

        .start-button:hover {
            background-color: #5d4037;
            transform: translateY(-3px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.4);
        }

        .start-button:active {
            transform: translateY(0);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="title-section">
            <h2>Tên Đề Tài</h2>
            <h3>Xây Dựng Website Bán Cà Phê Trực Tuyến (Web Application)</h3>
            <p>Năm học: 2024 – 2025</p>
            <p>Nhóm thực hiện: Nhóm 10</p>
        </div>

        <ul class="team-members-list">
            <li>
                <strong>Võ Văn Trí</strong>
                <span>MSSV: 22110444</span>
            </li>
            <li>
                <strong>Võ Minh Khoa</strong>
                <span>MSSV: 22110355</span>
            </li>
            <li>
                <strong>Trương Quốc Duy</strong>
                <span>MSSV: 22110298</span>
            </li>
        </ul>

        <div class="footer">
            <p>Thành phố Hồ Chí Minh, tháng 5, năm 2025</p>
        </div>

        <a href="sanpham.jsp" class="start-button">Bắt Đầu</a>
    </div>

</body>
</html>
