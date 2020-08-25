package com.cts.customer.request.utils;

public enum RequestTestDataFile implements JsonMapperUtil{
	
	REQUEST_INFORMATION_REQUEST(CUSTOMER_REQUEST_PATH,"createNewCustomerRequest.json");
	
	private String fileUri;
  
	
	private RequestTestDataFile(String path,String file) {
		this.fileUri = path+file;
	}
	@Override
	public String getFileURI() {
	
		return fileUri;
	}

}
