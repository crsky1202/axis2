package com.wasu.webservice.client;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis2.AxisFault;

public class ServiceTest extends HttpServlet {

	private static final long serialVersionUID = -4532040256586301290L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			testqueryBal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	public void testqueryBal() throws java.lang.Exception {

		//String pwd=TripleDES.encrypt_3DES("583523", MD5.crypt("31400000003147724163").substring(0,24));
		String tt =
			"<RequestBean>" +
			"<cardNo>31400000003147724163</cardNo>" +
			"<certNo>33048219800430006X</certNo>" +
			"<clientType>1</clientType>" +
			"<pwd>924b/Kww5OI=</pwd>" +
			"</RequestBean>";
		//execute.setInXml(tt);
		//<taskDate>2013-06</taskDate><pCount>10</pCount><pageNo>1</pageNo><recvBrchId>10010002</recvBrchId><xmName>王晓庭</xmName><certNo>330425198201310315</certNo>
		//<certNo>330421198202150012</certNo><mobileNo>13957339887</mobileNo><pwd>081114</pwd>
		try {
			AutoEquiWebserviceStub sb = new AutoEquiWebserviceStub();
			AutoEquiWebserviceStub.LoginValidate gp = new AutoEquiWebserviceStub.LoginValidate();
			gp.setInXml(tt);
			try {
			//sb._getServiceClient().getOptions().setProperty("CHUNKED","true"); 
				
			String sss=	sb.loginValidate(gp).get_return();//execute(gp).get_return();
			System.out.println("666666==="+sss);
			} catch (RemoteException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
}
