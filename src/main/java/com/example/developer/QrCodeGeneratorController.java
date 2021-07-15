package com.example.developer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.qrcode.QRCodeWriter;

@Controller
public class QrCodeGeneratorController {
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping(value = "/getqr",method =RequestMethod.POST)
   	public HttpEntity<byte[]> home(@ModelAttribute QRDetails qrd) throws Exception
	{
		return generateQRCode(qrd.getText(),qrd.getWidth(),qrd.getHeight());
	}
	
   	@GetMapping(value = "/generateQRCode")
   	public HttpEntity<byte[]> generateQRCode(String codeText,Integer width,Integer height)throws Exception 
	{
		byte[] image =QrCodeGenerator.getQRCodeImage(codeText, width, height);
   		HttpHeaders headers = new HttpHeaders();
   		headers.setContentType(MediaType.IMAGE_JPEG);
   		headers.setContentLength(image.length);
   		return new HttpEntity<byte[]>(image, headers);
   	}
	
}
