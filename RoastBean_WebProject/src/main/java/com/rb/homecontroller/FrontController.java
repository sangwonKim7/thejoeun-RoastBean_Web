package com.rb.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.command.Command;
import com.rb.command.CommandAdminLogin;
import com.rb.command.CommandBeanInfoList;
import com.rb.command.CommandBoardcommentlist;
import com.rb.command.CommandBoardcontent;
import com.rb.command.CommandBoarddelete;
import com.rb.command.CommandBoardlikeboard;
import com.rb.command.CommandBoardlist;
import com.rb.command.CommandBoardmylist;
import com.rb.command.CommandBoardnoticelist;
import com.rb.command.CommandBoardreply;
import com.rb.command.CommandBoardsearch;
import com.rb.command.CommandBoardupdate;
import com.rb.command.CommandBoardviewreply;
import com.rb.command.CommandBoardwrite;
import com.rb.command.CommandCartDelete;
import com.rb.command.CommandCartInsert;
import com.rb.command.CommandCartList;
import com.rb.command.CommandCommentdelete;
import com.rb.command.CommandCommentupdate;
import com.rb.command.CommandCommentwrite;
import com.rb.command.CommandCsNoticeInsertAdmin;
import com.rb.command.CommandCsNoticeListUser;
import com.rb.command.CommandCsNoticeUpdateAdmin;
import com.rb.command.CommandCsQnaAdminAction;
import com.rb.command.CommandCsQnaList;
import com.rb.command.CommandCsQnaQuestion;
import com.rb.command.CommandCsQnaUserUpdate;
import com.rb.command.CommandManageMainUserOrder;
import com.rb.command.CommandManageOrdersList;
import com.rb.command.CommandManageOrdersSearch;
import com.rb.command.CommandManageProductDelete;
import com.rb.command.CommandManageProductInsert;
import com.rb.command.CommandManageProductInsert1;
import com.rb.command.CommandManageProductList;
import com.rb.command.CommandManageProductSearch;
import com.rb.command.CommandManageProductSeen;
import com.rb.command.CommandManageProductUpdate;
import com.rb.command.CommandManageUserList;
import com.rb.command.CommandManageUserSearch;
import com.rb.command.CommandMyQnaList;
import com.rb.command.CommandMyorderlist;
import com.rb.command.CommandOrder;
import com.rb.command.CommandOrderInsert;
import com.rb.command.CommandProductDetail;
import com.rb.command.CommandProductList;
import com.rb.command.CommandReview;
import com.rb.command.CommandReviewDelete;
import com.rb.command.CommandReviewList;
import com.rb.command.CommandReviewMyList;
import com.rb.command.CommandReviewMyListEdit;
import com.rb.command.CommandReviewUpdate;
//import com.rb.command.CommandReviewMyList;
//import com.rb.command.CommandReviewMyListEdit;
//import com.rb.command.CommandReviewUpdate;
import com.rb.command.CommandUserCheck;
import com.rb.command.CommandUserCheckId;
import com.rb.command.CommandUserCheckNick;
import com.rb.command.CommandUserInfoPwcheck;
import com.rb.command.CommandUserLogin;
import com.rb.command.CommandUserLoginApi;
import com.rb.command.CommandUserSignup;
import com.rb.command.CommandUserSignupApi;
import com.rb.command.CommandUserinfo;
import com.rb.command.CommandUserinfoUpdate;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public FrontController() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      actionDo(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      actionDo(request, response);
   }

   private void actionDo(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");

      String viewPage = null;
      Command command = null;

      String uri = request.getRequestURI();
      String conPath = request.getContextPath();
      String com = uri.substring(conPath.length());

		// Paging
		HttpSession session = request.getSession();

		int curPage = 1;
		if(session.getAttribute("cpage") != null) {
			curPage = (int)session.getAttribute("cpage");
		}

		switch (com) {
		// --------------------- ?????? Controller Start ---------------------
		// ????????? ??????
		case ("/login.do"):
			command = new CommandUserLogin();
			command.execute(request, response);
			int checkLogin = (int) request.getAttribute("checkLogin");
			if(checkLogin == 1) {
				viewPage = "index.jsp";
			}else {
				viewPage = "login.jsp";
			}
			break;
		// API ????????? ??????
		case ("/login_api.do"):
			command = new CommandUserLoginApi();
			command.execute(request, response);
			int checkLoginApi = (int) request.getAttribute("checkLoginApi");
			if(checkLoginApi == 1) {
				viewPage = "index.jsp";
			}else {
				viewPage = "signup_api.jsp";
			}
			break;
		// ????????? ????????? ??????
		case ("/login_admin.do"):
			command = new CommandAdminLogin();
			command.execute(request, response);
			int checkLoginAdmin = (int) request.getAttribute("checkLoginAdmin");
			if(checkLoginAdmin == 1) {
				viewPage = "index.jsp";
			}else {
				viewPage = "login_api.jsp";
			}
			break;
		// ????????? ?????? ??????
		case ("/check_id.do"):
			command = new CommandUserCheckId();
			command.execute(request, response);
			viewPage = "signup.jsp";
			break;
		// ????????? ?????? ??????
		case ("/check_nick.do"):
			command = new CommandUserCheckNick();
			command.execute(request, response);
			viewPage = "signup.jsp";
			break;
		// ????????? ?????? ??????
		case ("/check_id_info.do"):
			command = new CommandUserCheckId();
			command.execute(request, response);
			viewPage = "mypage_info_update.jsp";
			break;
		// ????????? ?????? ??????
		case ("/check_nick_info.do"):
			command = new CommandUserCheckNick();
			command.execute(request, response);
			viewPage = "mypage_info_update.jsp";
			break;
		// signup ??????
		case ("/signup.do"):
			command = new CommandUserSignup();
			command.execute(request, response);
			viewPage = "index.jsp";
			break;
		// API signup ??????
		case ("/signup_api.do"):
			command = new CommandUserSignupApi();
			command.execute(request, response);
			viewPage = "index.jsp";
			break;
		// ???????????? ??????
		case ("/logout.do"):
			session.invalidate();
			viewPage = "index.jsp";
			break;
		// ???????????????/??? ?????? ??????
		case ("/mypage_info.do"):
			command = new CommandUserinfo();
			command.execute(request, response);
			viewPage = "mypage_info.jsp";
			break;
		// ???????????????/ ???????????????????????? // ?????? 22.11.19_SanwonKim
		case ("/mypage_info_pwcheck.do"):
			command = new CommandUserInfoPwcheck();
			command.execute(request, response);
//			String page = (String) request.getAttribute("page");
			int userPwCheck = (int) request.getAttribute("userPwCheck");
			if(userPwCheck == 1) {
				viewPage = "mypage_info_update_list.do";
			}else {
				viewPage = "mypage_info_pwcheck.jsp";
			}
//			viewPage = page;
			break;
		// ???????????????/?????????????????? ??? ?????? ??????
		case ("/mypage_info_update_list.do"):
			command = new CommandUserinfo();
			command.execute(request, response);
			viewPage = "mypage_info_update.jsp";
			break;
		// ???????????????/??? ?????? ????????????
		case ("/mypage_info_update.do"):
			command = new CommandUserinfoUpdate();
			command.execute(request, response);
			viewPage = "mypage_info.do";
			break;
		// ???????????????: ??? ?????? ?????? ?????? / ?????? 22.11.12_SangwonKim
		case ("/mypage_order_list.do"):
			command = new CommandMyorderlist();
			command.execute(request, response);
			viewPage = "mypage_order_list.jsp";
			break;
		// ???????????????:My QnA List ???????????? / ?????? 22.11.13_2:20_SangwonKim
		case ("/mypage_qna_list.do"): 
			command = new CommandMyQnaList();
			command.execute(request, response);
			viewPage = "mypage_qna_list.jsp";
			break;
		// ???????????????:My QnA ?????? / ?????? 22.11.13_6:20_SangwonKim
		case ("/qna_update_by_user.do"): // ????????? ???????????? ????????????, ?????? ????????? ??????????????? ????????????
			command = new CommandCsQnaUserUpdate();
			command.execute(request, response);
			viewPage = "mypage_qna_list.do";
			break;
		// QnA:??????:???????????? Insert / ?????? 22.11.13_18:00_SangwonKim
		case ("/qna_question_by_user.do"):
			command = new CommandCsQnaQuestion();
			command.execute(request, response);
			viewPage = "cs_qna.jsp";
			break;
		// QnA:?????????:??????????????? ???????????? Select / ?????? 22.11.13_21:50_SangwonKim
		case ("/qna_list_by_admin.do"):
			command = new CommandCsQnaList();
			command.execute(request, response);
			viewPage = "cs_qna_admin.jsp";
			break;
		// QnA:?????????:????????? ????????????,???????????? Insert&Update / ?????? 22.11.13_11:00_SangwonKim
		case ("/qna_answer_by_admin.do"):
			command = new CommandCsQnaAdminAction();
			command.execute(request, response);
			viewPage = "qna_list_by_admin.do";
			break;
		// Notice ???????????? Select / ?????? 22.11.14_06:00_SangwonKim
		case ("/notice_list.do"): //user,admin list
			command = new CommandCsNoticeListUser();
			command.execute(request, response);
			viewPage = "cs_notice.jsp";
			break;
		// Notice Update / ?????? 22.11.14_16:00_SangwonKim
		case ("/notice_update_by_admin.do"): // Update, Delete
			command = new CommandCsNoticeUpdateAdmin();
			command.execute(request, response);
			viewPage = "notice_list.do";
			break;
		// Notice Insert / ?????? 22.11.14_21:00_SangwonKim
		case ("/notice_insert_by_admin.do"): // Update, Delete
			command = new CommandCsNoticeInsertAdmin();
			command.execute(request, response);
			viewPage = "notice_list.do";
			break;
		// --------------------- ?????? Controller End -----------------------

		// --------------------- ?????? Controller Start -----------------------
		// ?????? ?????? ?????????
		case ("/beaninfo.do"):
			command = new CommandBeanInfoList();
			command.execute(request, response);
			viewPage = "beaninfo.jsp";
			break;
		// --------------------- ?????? Controller End -----------------------
  
		// --------------------- ?????? Controller Start ---------------------
		case ("/productList.do"):
			command = new CommandProductList();
			command.execute(request, response);
			viewPage = "productList.jsp";
			break;
		case ("/productDetail.do"):
			command = new CommandProductDetail();
			command.execute(request, response);
			viewPage = "productDetail.jsp";
			break;
		case ("/cartOrderInsert.do"):
			command = new CommandCartInsert();
			command.execute(request, response);
			viewPage = "cartOrder.do";
			break;
		case ("/cartOrder.do"):
			command = new CommandCartList();
			command.execute(request, response);
			viewPage = "cartOrder.jsp";
			break;
		case ("/insertCart.do"):
			command = new CommandCartInsert();
			command.execute(request, response);
			viewPage = "productDetail.do";
			break;
		case ("/deleteCart.do"):
			command = new CommandCartDelete();
			command.execute(request, response);
			viewPage = "cartOrder.do";
			break;
		case ("/order.do"):
			command = new CommandOrderInsert();
			command.execute(request, response);
			viewPage = "orderUpdate.do";
			break;
		case ("/orderUpdate.do"):
			command = new CommandOrder();
			command.execute(request, response);
			viewPage = "index.jsp";
			break;
		case ("/productReview.do"):
			command = new CommandReviewList();
			command.execute(request, response);
			viewPage = "productReview.jsp";
			break;
		case ("/reviewInsert.do"):
			command = new CommandReview();
			command.execute(request, response);
			viewPage = "mypage_order_list.do";
			break;
		case ("/deleteReview.do"):
			command = new CommandReviewDelete();
			command.execute(request, response);
			viewPage = "productDetail.do?product_id="+request.getParameter("product_id");
			break;
		case ("/findPwUserCheck.do"):
			command = new CommandUserCheck();
			command.execute(request, response);
			viewPage = "find_pw.jsp";
			break;
		case ("/myboardreviewlist.do"):
			command = new CommandReviewMyList();
			command.execute(request, response);
			viewPage = "cboardmylist.jsp";
			break;
		case ("/reviewEdit.do"):
			command = new CommandReviewList();
			command.execute(request, response);
			viewPage = "reviewUpdateEdit.do";
			break;
		case ("/reviewUpdateEdit.do"):
			command = new CommandReviewMyListEdit();
			command.execute(request, response);
			viewPage = "productReviewUpdate.jsp";
			break;
		case ("/reviewDelete.do"):
			command = new CommandReviewDelete();
			command.execute(request, response);
			viewPage = "myboardlist.do";
			break;
		case ("/reviewUpdate.do"):
			command = new CommandReviewUpdate();
			command.execute(request, response);
			viewPage = "myboardlist.do";
			break;
		// --------------------- ?????? Controller End -----------------------
			
		// --------------------- ?????? ?????? Controller Start ---------------------
		case ("/ManageMain.do"): // main???????????? ????????????
			command = new CommandManageMainUserOrder();
			command.execute(request, response);
			viewPage = "manage_main.jsp";
			break;
		case ("/UserListSelect.do"): // ????????? ???????????? ??????????????? ?????? ????????? ????????? do??? ??????
			command = new CommandManageUserList();
			command.execute(request, response);
			viewPage = "manage_user_list.jsp";
			break;
			case ("/ManageProductList.do"): // ?????? ????????? select
			command = new CommandManageProductList();
			command.execute(request, response);
			viewPage = "manage_product_list.jsp";
			break;
			case ("/ManageProductInsert.do"):
			viewPage = "manage_product_insert.jsp";
			break;
			case ("/ManageProductListInsert.do"): // ????????? ?????? ?????? ??? ??????
			command = new CommandManageProductInsert();
			command.execute(request, response);
			viewPage = "manage_product_insert1.jsp";
			break;
			case ("/ManageProductListInsert1.do"): // ????????? ?????? ?????? ??? ??????
			command = new CommandManageProductInsert1();
			command.execute(request, response);
			viewPage = "ManageProductList.do";
			break;
			case ("/ManageProductDelete.do"): // ????????? ?????? ??????
			command = new CommandManageProductDelete();
			command.execute(request, response);// ??????
			viewPage = "ManageProductList.do";
			break;
			case ("/ManageProductUpdateSelete.do"): // ????????????
			command = new CommandManageProductSeen();
			command.execute(request, response);// ??????
			viewPage = "manage_product_update.jsp";
			break;
			case ("/ManageProductUpdate.do"):// ????????? ?????? ??????
			command = new CommandManageProductUpdate();
			command.execute(request, response);// ??????
			viewPage = "ManageProductList.do";
			break;
			case ("/ManageProductSearch.do"):// ???????????? ??????
			command = new CommandManageProductSearch();
			command.execute(request, response);
			viewPage = "manage_product_list.jsp";
			break;
		
			case ("/ManageOrdersList.do"): // product orders list
			command = new CommandManageOrdersList();
			command.execute(request, response);
			viewPage = "manage_orders_list.jsp";
			break;
			case ("/ManageOrdersListSearch.do"):
			command = new CommandManageOrdersSearch();
			command.execute(request, response);
			viewPage = "manage_orders_list.jsp";
			break;
			case ("/ManageUserListSearch.do"):
			command = new CommandManageUserSearch();
			command.execute(request, response);
			viewPage = "manage_user_list.jsp";
			break;
		// --------------------- ?????? ?????? Controller End -----------------------
			
		// --------------------- ???&?????? Controller Start ---------------------
		// ??????????????? ????????? list ????????????
		case("/list.do"):
			command = new CommandBoardlist();
			command.execute(request, response);
			command = new CommandBoardnoticelist();
			command.execute(request, response);
			viewPage = "cboardlist.jsp";
			break;
			// case("/nList.do"):
			// command = new CommandBoardnoticelist();
			// command.execute(request, response);
			// viewPage = "cboardlist.jsp";
			// break;
		// ????????? ???????????? ??????
		case("/boardwrite_view.do"):
			viewPage = "cboardwrite_view.jsp";
			break;
		// ?????????
		case("/boardwrite.do"):
			command = new CommandBoardwrite();
			command.execute(request, response);
			viewPage = "list.do?page=" + curPage;
			break;
		// ????????????
		case ("/bSearch.do"):
			command = new CommandBoardsearch();
			command.execute(request, response);
			viewPage = "cboardsearch.jsp";
			break;
		// Detail Page & comment list
		case ("/content_view.do"):
			command = new CommandBoardcontent();
			command.execute(request, response);
			command = new CommandBoardcommentlist();
			command.execute(request, response);
			viewPage = "cboardcontent_view.jsp";
			break;
		// ???????????? page
		case ("/modify_view.do"):
			command = new CommandBoardcontent();
			command.execute(request, response);
			viewPage = "cboardupdate.jsp";
			break;
		// ????????????
		case ("/modify.do"):
			command = new CommandBoardupdate();
			command.execute(request, response);
			command = new CommandBoardcontent();
			command.execute(request, response);
			viewPage = "cboardcontent_view.jsp";
			break;
		// ?????? page
		case ("/communitydelete.do"):
			command = new CommandBoarddelete();
			command.execute(request, response);
			viewPage = "list.do?page=" + curPage;
			break;
		// ???????????????
		case ("/boardlike.do"):
			command = new CommandBoardlikeboard();
			command.execute(request, response);
			viewPage = "content_view.do";
			break;
		// view reply[?????????????????????] Page
		case ("/reply_view.do"):
			command = new CommandBoardviewreply();
			command.execute(request, response);
			viewPage = "cboardreply_view.jsp";
			break;
		// ????????????
		case ("/reply.do"):
			command = new CommandBoardreply();
			command.execute(request, response);
			viewPage = "list.do?page=" + curPage;
			break;
		//Community Notice ??????????????? ????????????
		case ("/cboardnotice.do"):
			command=new CommandBoardnoticelist();
			command.execute(request, response);
			viewPage="cboardnotice.jsp";
			break;
		// ----------- Comment ------------
		// ????????????
		case ("/coWrite.do"):
			command = new CommandCommentwrite();
			command.execute(request, response);
			viewPage = "content_view.do";
			break;
		// ????????????
		case ("/coDelete.do"):
			command = new CommandCommentdelete();
			command.execute(request, response);
			viewPage = "content_view.do";
			break;
		// ????????????
		case ("/coModify.do"):
			command = new CommandCommentupdate();
			command.execute(request, response);
			viewPage = "content_view.do";
			break;
		// ?????? ??? ????????? ?????????
			case ("/myboardlist.do"):
			command = new CommandBoardmylist();
			command.execute(request, response);
			viewPage = "myboardreviewlist.do";
			break;
		// --------------------- ???&?????? Controller End -----------------------

      } // switch

      RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
      dispatcher.forward(request, response);
   }

} // End