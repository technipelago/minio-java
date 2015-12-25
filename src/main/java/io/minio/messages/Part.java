/*
 * Minio Java Library for Amazon S3 Compatible Cloud Storage, (C) 2015 Minio, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.minio.messages;

import java.util.Date;
import com.google.api.client.util.Key;
import io.minio.DateFormat;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Part extends XmlEntity {
  @Key("PartNumber")
  private int partNumber;
  @Key("ETag")
  private String etag;
  @Key("LastModified")
  private String lastModified;
  @Key("Size")
  private Long size;

  public Part() {
    super();
    super.name = "Part";
  }


  /**
   * constructor.
   */
  public Part(int partNumber, String etag) {
    this();

    this.partNumber = partNumber;
    this.etag = etag;
  }


  public int getPartNumber() {
    return partNumber;
  }

  public void setPartNumber(int partNumber) {
    this.partNumber = partNumber;
  }

  public String getETag() {
    return etag.replaceAll("\"", "");
  }

  public void setETag(String etag) {
    this.etag = etag.replaceAll("\"", "");
  }

  public String getLastModified() {
    return lastModified;
  }

  public void setLastModified(String lastModified) {
    this.lastModified = lastModified;
  }

  public Date getParsedLastModified() {
    return DateFormat.RESPONSE_DATE_FORMAT.parseDateTime(lastModified).toDate();
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

}