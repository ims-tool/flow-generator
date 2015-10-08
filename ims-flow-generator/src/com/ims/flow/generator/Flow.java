package com.ims.flow.generator;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ims.flow.db.FlowDao;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/flow")
public class Flow {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return FlowDao.getFormList();
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
	    return FlowDao.getFormList();
  }

  // This method is called if HTML is request
  @Path("/forms")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getForms() {
	    return FlowDao.getFormList();
  }

  @Path("/tags")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getTags() {
	    return FlowDao.getTagList();
  }


  
  @Path("/tagTypes")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getTagTypess() {
	    return FlowDao.getTagTypesList();
  }
  
  

  @Path("/noinputs")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getNoInput() {
	    return FlowDao.getNoInputList();
  }
  

  
  
  @POST
  @Path("/exec")
  @Produces(MediaType.TEXT_HTML)
  public String getExec(@FormParam(value = "pl") String pl) {
	    return FlowDao.execPlpgsql(pl);
  }
  
} 