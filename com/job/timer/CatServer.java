package com.job.timer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class CatServer{
	private static ServerSocket ss;
	public static HashMap<String, ClientBean>  online;
	
	static{
		try {
			ss=new ServerSocket(8520);
			online = new HashMap<String,ClientBean>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	class CatClientThrend extends Thread{
		private Socket client;
		private CatBean bean;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		public CatClientThrend(Socket client2) {
			// TODO Auto-generated constructor stub
		}
		public void run(){
			while(true){
				try {
					ois = new ObjectInputStream(client.getInputStream());
					bean = (CatBean)ois.readObject();
					switch(bean.getType()){
					case 0:{
						ClientBean cbean =new ClientBean();
						cbean.setname(bean.getName());
						cbean.setsocket(client);
						online.put(bean.getName(), cbean);
						CatBean serverBean =new CatBean();
						serverBean.setType(0);
						serverBean.setInfo(bean.getTimer()+bean.getName());
						
						HashSet<String> set = new HashSet<String>();
						set.addAll(online.keySet());
						serverBean.setClients(set);
						sendAll(serverBean);
						break;				
					}
					case -1:{
						CatBean serverBean =new CatBean();
						serverBean.setType(-1);
						oos =new ObjectOutputStream(client.getOutputStream());
						oos.writeObject(serverBean);
						oos.flush();
						online.remove(bean.getName());
						CatBean serverBean2 =new CatBean();
						serverBean2.setInfo(bean.getTimer()+bean.getName());
						serverBean2.setType(0);
						HashSet<String> set = new HashSet<String>();
						set.addAll(online.keySet());
						serverBean2.setClients(set);

						sendAll(serverBean2);
						return;
					}
					case 1:{
						CatBean serverBean = new CatBean();
						serverBean.setType(1);
						serverBean.setClients(bean.getClients());
						serverBean.setInfo(bean.getName());
						serverBean.setName(bean.getName());
						serverBean.setTimer(bean.getTimer());
						sendMessage(serverBean);
						break;
					}
					case 2:{
						CatBean serverBean = new CatBean();
						String info = bean.getTimer()+""+bean.getName();
						serverBean.setType(2);
						serverBean.setClients(bean.getClients());
						serverBean.setFileName(bean.getFileName());
						serverBean.setSize(bean.getSize());
						serverBean.setInfo(info);
						serverBean.setName(bean.getName());
						serverBean.setTimer(bean.getTimer());
						sendMessage(serverBean);
						break;
					}
					case 3:{
						CatBean serverBean = new CatBean();
						
						serverBean.setType(3);
						serverBean.setClients(bean.getClients());
						serverBean.setTo(bean.getTo());
						serverBean.setFileName(bean.getFileName());
						serverBean.setIp(bean.getIp());
						serverBean.setPort(bean.getPort());
						serverBean.setName(bean.getName());
						serverBean.setTimer(bean.getTimer());
						sendMessage(serverBean);
						break;
					}
					case 4:{
						CatBean serverBean = new CatBean();

						serverBean.setType(4);
						serverBean.setClients(bean.getClients()); // �ļ���Դ
						serverBean.setTo(bean.getTo()); // �ļ�Ŀ�ĵ�
						serverBean.setFileName(bean.getFileName());
						serverBean.setInfo(bean.getInfo());
						serverBean.setName(bean.getName());// ���յĿͻ����
						serverBean.setTimer(bean.getTimer());
						sendMessage(serverBean);

						break;
					}
					default: {
						break;
					}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					close();
				}			
			}

		}
		private void sendMessage(CatBean serverBean) {
			
			Set<String> cbs = online.keySet();
			Iterator<String> it = cbs.iterator();
			
			HashSet<String> clients = serverBean.getClients();
			while (it.hasNext()) {
				
				String client = it.next();
				
				if (clients.contains(client)) {
					Socket c = online.get(client).getsocket();
					ObjectOutputStream oos;
					try {
						oos = new ObjectOutputStream(c.getOutputStream());
						oos.writeObject(serverBean);
						oos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}

		
		public void sendAll(CatBean serverBean) {
			Collection<ClientBean> clients = online.values();
			Iterator<ClientBean> it = clients.iterator();
			ObjectOutputStream oos;
			while (it.hasNext()) {
				Socket c = it.next().getsocket();
				try {
					oos = new ObjectOutputStream(c.getOutputStream());
					oos.writeObject(serverBean);
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		private void close(){
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void start(){
		try {
			while(true){
				Socket client = ss.accept();
				new CatClientThrend(client).start();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args){
		new CatServer().start();
	}
	
}
