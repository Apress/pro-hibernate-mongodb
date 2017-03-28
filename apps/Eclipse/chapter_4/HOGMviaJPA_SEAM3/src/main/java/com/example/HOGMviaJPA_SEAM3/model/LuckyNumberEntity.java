package com.example.HOGMviaJPA_SEAM3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Version;
import java.lang.Override;

@Entity
@Table(name="seam")
public class LuckyNumberEntity implements java.io.Serializable
{
 
	private static final long serialVersionUID = 1L;
	
@Id
   private @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   Long id = null;
   @Version
   private @Column(name = "version")
   int version = 0;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((LuckyNumberEntity) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   @Column
   private int luckynumber;

   public int getLuckynumber()
   {
      return this.luckynumber;
   }

   public void setLuckynumber(final int luckynumber)
   {
      this.luckynumber = luckynumber;
   }

   public String toString()
   {
      String result = "";
      result += luckynumber;
      return result;
   }
}