 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>manege_product_update</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,600,600i,700,700i|Satisfy|Comic+Neue:300,300i,400,400i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Delicious - v4.9.1
  * Template URL: https://bootstrapmade.com/delicious-free-restaurant-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body link="black" vlink="black" alink="navy">
<!-- ======= Header ======= -->
	<%@include file = "header_manage.jsp" %>
  <!-- End Header -->

  <main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>product update</h2>
          <ol>
            <li><a href="ManageMain.do">Home</a></li>
            <li>product update</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

<!--  ---------------------------------- ?????? ????????? ?????? ---------------------------------- -->
	
<div style="text-align: center;">
		<br>
		<br> &nbsp;&nbsp;&nbsp;
		<h2>?????? ????????????</h2>
		&nbsp;&nbsp;&nbsp;
	</div>
	
	<form action="ManageProductUpdate.do" method="post">
	   
	   <table style="margin-left: auto; margin-right: auto;">
	      <tr>
	         <td>????????????</td>
	         <td><input type="text" name="product_id" size="40" value="${product_select.product_id }" readonly="readonly"></td>
	      </tr>
	      <tr>
	         <td>?????????</td>
	         <td><input type="text" name="product_name" size="40" value="${product_select.product_name }"></td>
	      </tr>
	     <%--  <tr>
	         <td>?????????</td>
	         <td>
	           <select name="product_nation" style="WIDTH: 240pt; HEIGHT: 24pt">
	               <option selected="selected" value="${product_select.product_nation }">${product_select.product_nation }</option>
	               <option value="??????">??????</option>
	               <option value="???????????????">???????????????</option>
	               <option value="?????????">?????????</option>
	               <option value="????????????">????????????</option>
	            </select>
	         </td>
	      </tr>  --%>
	      <tr>
	         <td>?????? ?????????</td>
	         <td><img src="assets/img/product/${product_select.product_image }" width="320px" height="150px"></td>
	      </tr>
	      <tr>
	         <td></td>
	         <td><input type="file" name="product_image"value="${product_select.product_image }"></td>
	      </tr>
	      <tr>
	         <td>?????? ??????</td>
	         <td><textarea style="WIDTH: 240pt; HEIGHT: 50pt" name="product_info" value = "${product_select.product_info}">${product_select.product_info}</textarea></td>
	      </tr>
	      <tr>
	         <td>?????? ??????</td>
	         <td><input type="text" name="product_stock" size="40" value="${product_select.product_stock }"></td>
	      </tr>
	      <tr>
	         <td>?????? ??????</td>
	         <td><input type="text" name="product_weight" size="40" value="${product_select.product_weight }"></td>
	      </tr>
	      <tr>
	         <td>?????? ??????</td>
	         <td><input type="text" name="product_price" size="40" value="${product_select.product_price }"></td>
	      </tr>
	     <tr>
	        <td>?????? ??????</td>
	        <td><input type="text" name="category_type" size="40" value="${product_select. category_type}"></td>
	     </tr>
	     <tr>
	        <td align=center>??????</td>
	        <td>
	        <select name="category_acidity" style="WIDTH: 240pt; HEIGHT: 24pt">
	           <option selected="selected" value="${product_select.category_acidity }">${product_select.category_acidity }</option>
	           <option value="1">1</option>
	           <option value="1.5">1.5</option>
	           <option value="2">2</option>
	           <option value="2.5">2.5</option>
	           <option value="3">3</option>
	           <option value="3.5">3.5</option>
	           <option value="4">4</option>
	           <option value="4.5">4.5</option>
	           <option value="5">5</option>
	        </select>
	        </td>	        
	     </tr>
	     <tr>
	        <td align=center>?????????</td>
	        <td>
	        <select name="category_body" style="WIDTH: 240pt; HEIGHT: 24pt">
	           <option selected="selected" value="${product_select.category_body }">${product_select.category_body }</option>
	           <option value="1">1</option>
	           <option value="1.5">1.5</option>
	           <option value="2">2</option>
	           <option value="2.5">2.5</option>
	           <option value="3">3</option>
	           <option value="3.5">3.5</option>
	           <option value="4">4</option>
	           <option value="4.5">4.5</option>
	           <option value="5">5</option>
	        </select>
	        </td>	        
	     </tr>
	     <tr>
	        <td align=center>??????</td>
	        <td>
	        <select name="category_sweet" style="WIDTH: 240pt; HEIGHT: 24pt">
	           <option selected="selected" value="${product_select.category_sweet }">${product_select.category_sweet }</option>
	           <option value="1">1</option>
	           <option value="1.5">1.5</option>
	           <option value="2">2</option>
	           <option value="2.5">2.5</option>
	           <option value="3">3</option>
	           <option value="3.5">3.5</option>
	           <option value="4">4</option>
	           <option value="4.5">4.5</option>
	           <option value="5">5</option>
	        </select>
	        </td>	        
	     </tr>
	     <tr>
	        <td align=center>?????????</td>
	        <td>
	        <select name="category_aroma" style="WIDTH: 240pt; HEIGHT: 24pt">
	           <option selected="selected" value="${product_select.category_aroma }">${product_select.category_aroma }</option>
	           <option value="1">1</option>
	           <option value="1.5">1.5</option>
	           <option value="2">2</option>
	           <option value="2.5">2.5</option>
	           <option value="3">3</option>
	           <option value="3.5">3.5</option>
	           <option value="4">4</option>
	           <option value="4.5">4.5</option>
	           <option value="5">5</option>
	        </select>
	        </td>	        
	     </tr>
	      <tr>
	         <td></td>
	         <td>
	            <input type="submit" value="????????????"><br>
	            <a href="ManageProductList.do" style="text-decoration:none">?????????????????? ????????????</a><br>
	            <a href="manage_main.jsp" style="text-decoration: none;">????????? ????????? ????????????</a>
	         </td>
	      </tr>
	      <tr>
	         <td></td>
	         <td><br><br></td>
	      </tr>
	   </table>
	</form>
	<!--  ---------------------------------- ?????? ????????? ?????? ----------------------------------  -->


  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
	<%@include file = "footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
	
</body>
</html>