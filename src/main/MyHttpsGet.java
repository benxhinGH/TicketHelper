package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import log.Log;

/*
 * 发送https请求类
 */

public class MyHttpsGet {
	
	private SSLSocketFactory ssf;

	public MyHttpsGet(){
		Init();
	}
	/*
	 * 初始化函数，构造SSLSocketFactory
	 */
	private void Init(){
	try {
		SSLContext sslContext=SSLContext.getInstance("SSL");
		TrustManager[] tm={new X509TrustManager(){

			@Override
			public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				// TODO Auto-generated method stub
				return new X509Certificate[]{};
			}
			
		}};
		sslContext.init(null, tm, new java.security.SecureRandom());
		ssf=sslContext.getSocketFactory();
		
		
		/*String urlStr="https://kyfw.12306.cn/otn/resources/js/framework/station_name.js?station_version=1.8994";
		URL url=new URL(urlStr);
		
		HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
		con.setSSLSocketFactory(ssf);
		
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
		
		StringBuffer retData=new StringBuffer();
		String temp="";
		
		while((temp=bufferedReader.readLine())!=null){
			retData.append(temp);
		}
		
		String[] first=retData.toString().split("@");
		for(int i=1;i<first.length;++i){
			String[] second=first[i].split("\\|");
			
			System.out.println(second[1]+"----"+second[2]);
		}
		*/
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	/*
	 * 参数URL，get方法用于发送https请求
	 */
	public String get(URL url){
		
		HttpsURLConnection con;
		
		StringBuffer retData=new StringBuffer();
		String temp="";
		
		Log.d("MyHttpsGet", "发送https请求，url:"+url.toString());
		try {
			con = (HttpsURLConnection)url.openConnection();
			
			con.setSSLSocketFactory(ssf);
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
			
			while((temp=reader.readLine())!=null){
				retData.append(temp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retData.toString();
		

	}
	/*
	 * get重载方法，参数是字符串类型的url
	 */
	public String get(String str){
		URL url;
		try {
			url=new URL(str);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return get(url);
	}
	
}
