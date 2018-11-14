package com.job.timer;

import java.net.Socket;

class ClientBean{
	private String name;
	private Socket socket;
	public String getname() {
		  return name;		
	}
	public void setname(String name){
			this.name=name;
	}
	public Socket getsocket(){
		return socket;
	}
	public void setsocket(Socket socket){
		this.socket=socket;
	}
}
