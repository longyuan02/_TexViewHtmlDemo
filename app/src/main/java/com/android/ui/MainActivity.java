package com.android.ui;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button button1;
	Button button2;
	TextView textView;
	String html;
	MyEditText ed_my;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		textView = (TextView) findViewById(R.id.textView1);
		ed_my = (MyEditText)findViewById(R.id.ed_my);
		
//		\"content\": \"基金（Fund）有广义和狭义之分，从广义上说，基金是指为了某种目的而设立的具有一定数量的资金。主要包括信托投资基金、公积金、保险基金、退休基金，各种基金会的基金。人们平常所说的基金主要是指证券投资基金。\n证券投资的分析方法主要有如下三种：基本分析法，技术分析法、演化分析法，其中基本分析主要应用于投资标的物的价值判断和选择上，技术分析和演化分析则主要应用于具体投资操作的时间和空间判断上，作为提高证券投资分析有效性和可靠性的重要补充。\"
		html = "This text is normal<br>"
				+ "<img src=\"https://pic2.mazhan.com/upload/image/20151214/1450075727711760.png\" /><br>"
				+ "\"content\": \"人们平常所说的基金主要是指证券投资基金。证券投资的分析方法主要有如下三种"
				+ "<a href= \"path?ta_name=民生加银基金管理有限公司&fund_name=民生加银家盈理财月度B&fund_id=4042&level=&notion=&fund_type_first_name=债券型&fund_type_second_name=类货币理财型债券&manager_name=王滨&code=000090&fund_name_pinyin=msjyjylcydb&fund_type=&isAdd=0&fund_money_type=1\">这是个一个吃辣椒</a>"
				+ "斯柯达就发了坚实的" + "<a href= \"@@@@@@#\">这是个一个吃烧开后风开始觉得</a>";

		// textView.setText(getClickableHtml(html));
		Spanned sp1 = Html.fromHtml(html, new Html.ImageGetter() {  
		    @Override  
		    public Drawable getDrawable(String source) {  
		        InputStream is = null;  
		        try {  
		            is = (InputStream) new URL(source).getContent();  
		            Drawable d = Drawable.createFromStream(is, "src");  
		            d.setBounds(0, 0, d.getIntrinsicWidth(),  
		                    d.getIntrinsicHeight());  
		            is.close();  
		            return d;  
		        } catch (Exception e) {  
		            return null;  
		        }  
		    }  
		}, null);  
		textView.setText(sp1);
		ed_my.setText(sp1);
		ed_my.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				System.out.println("beforechange" + s.toString());
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				System.out.println("onchange" + s.toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
				System.out.println("afterchange" + s.toString());
			}
		});
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Bitmap bt = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
				ed_my.insertDrawable(bt);
			}
		});
//		textView.setMovementMethod(LinkMovementMethod.getInstance());
//		CharSequence text = textView.getText();
//		if (text instanceof Spannable) {
//			int end = text.length();
//			Spannable sp = (Spannable) textView.getText();
//			URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);
//			SpannableStringBuilder style = new SpannableStringBuilder(text);
//			style.clearSpans();// should clear old spans
//
//			// 循环把链接发过去
//			for (URLSpan url : urls) {
//				MyURLSpan myURLSpan = new MyURLSpan(url.getURL());
//				style.setSpan(myURLSpan, sp.getSpanStart(url),
//						sp.getSpanEnd(url), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//			}
//			textView.setText(style);
//		}
		// setContentView(textView);

	}

	// button1.setOnClickListener(new OnClickListener() {
	// @Override
	// public void onClick(View v) {
	// Spanned sp = Html.fromHtml(html);
	// textView.setText(sp);
	// }
	// });
	//
	// button2.setOnClickListener(new OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	// Spanned sp = Html.fromHtml(html, new Html.ImageGetter() {
	// @Override
	// public Drawable getDrawable(String source) {
	// InputStream is = null;
	// try {
	// is = (InputStream) new URL(source).getContent();
	//
	// Drawable d = Drawable.createFromStream(is, "src");
	// d.setBounds(0, 0, d.getIntrinsicWidth(),
	// d.getIntrinsicHeight());
	// is.close();
	// return d;
	// } catch (Exception e) {
	// return null;
	// }
	// }
	// }, null);
	// textView.setText(sp);
	// }
	//
	// });
	//
	// private class MyURLSpan extends ClickableSpan {
	//
	// private String mUrl;
	//
	// MyURLSpan(String url) {
	// mUrl = url;
	// }
	//
	// @Override
	// public void onClick(View widget) {
	// System.out.println("33333===="+mUrl);
	// // if(mUrl .equal(lianjie)){
	// // Toast.makeText(ctx, mUrl, Toast.LENGTH_LONG).show();
	// // widget.setBackgroundColor(Color.parseColor("#00000000"));
	// widget.setBackgroundColor(0x00000000);
	// //
	// // }
	// }
	// }

	private void setLinkClickable(
			final SpannableStringBuilder clickableHtmlBuilder,
			final URLSpan urlSpan) {
		int start = clickableHtmlBuilder.getSpanStart(urlSpan);
		int end = clickableHtmlBuilder.getSpanEnd(urlSpan);
		int flags = clickableHtmlBuilder.getSpanFlags(urlSpan);
		ClickableSpan clickableSpan = new ClickableSpan() {
			public void onClick(View view) {
				// Do something with URL here.
				System.out.println("@@@@@====" + "sdkjfk");
			}
		};

		// style.setSpan(myURLSpan, sp.getSpanStart(url),
		// sp.getSpanEnd(url), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

		clickableHtmlBuilder.setSpan(clickableSpan, start, end, flags);
	}

	/*private CharSequence getClickableHtml(String html) {
		Spanned spannedHtml = Html.fromHtml(html);
		SpannableStringBuilder clickableHtmlBuilder = new SpannableStringBuilder(
				spannedHtml);
		URLSpan[] urls = clickableHtmlBuilder.getSpans(0, spannedHtml.length(),
				URLSpan.class);
		for (final URLSpan span : urls) {
			setLinkClickable(clickableHtmlBuilder, span);
			System.out.println("span===" + span.getURL());
		}
		return clickableHtmlBuilder;
	}*/

	private class MyURLSpan extends ClickableSpan {
		private String mUrl;

		MyURLSpan(String url) {
			mUrl = url;
		}

		public void updateDrawState(TextPaint ds) {// List<TextPaint> ds
			ds.setColor(Color.parseColor("#4a91d3"));// 设置超链接颜色
			ds.setUnderlineText(false); // 超链接去掉下划线
		}

		@Override
		public void onClick(View widget) {
			// 判断是否热门话题
			System.out.println("33333====" + mUrl);
			InputFund inputFund = getInputFund(mUrl);
			widget.setBackgroundColor(0x00000000);
			System.out.println("name==" + inputFund.getFund_name());
		}
	}

	private InputFund getInputFund(String strfund) {
		String str = strfund.substring(strfund.indexOf("?"), strfund.length());
		String strs[] = str.split("&");
		String strs1[] = null;
		InputFund inputFund = new InputFund();
		for (int i = 0; i < strs.length; i++) {
			strs1 = null;
			strs1 = strs[i].split("=");
			if (strs1[0].equals("fund_name")) {
				inputFund.setFund_name(strs1[1]);
			}
			if (strs1[0].equals("fund_id")) {
				inputFund.setFund_id(strs1[1]);
			}
			if (strs1[0].equals("fund_money_type")) {
				inputFund.setFund_money_type(strs1[1]);
			}
			if (strs1[0].equals("code")) {
				inputFund.setCode(strs1[1]);
			}
		}
		return inputFund;
	}
}