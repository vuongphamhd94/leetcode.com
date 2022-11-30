package com.vuong.SQLSV.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "new")
public class NewEntity extends BaseEntyti {
	@Column(name = "title")
	private String titile;
	@Column(name = "thumbnail")
	private String thumbnail;
	@Column(name = "shortDescription")
	private String shortDescription;
	@Column(name = "content")
	private String content;

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
