package bigdata.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FloatDocValuesField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.document.*;

import java.io.File;
import java.io.IOException;

public class TestLucene {
  public static void testCreateIndex() throws IOException {

    //指定索引库的存放位置Directory对象
    Directory directory = FSDirectory.open(new File("/tmp/test_lucene2").toPath());
    //指定一个标准分析器，对文档内容进行分析
    Analyzer analyzer = new StandardAnalyzer();
    //创建indexwriterCofig对象
    IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
    //创建一个indexwriter对象
    IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

    Document document = new Document();
    document.add(new StringField("person", "amy", Field.Store.YES));
    document.add(new FloatField("person", 1.1f, Field.Store.NO));
    document.add(new FloatDocValuesField("person", 1.1f));

    indexWriter.addDocument(document);
    indexWriter.close();
  }

  private static void testReadFromIndex() throws IOException {
    //指定索引库的存放位置Directory对象
    Directory directory = FSDirectory.open(new File("/tmp/test_lucene2").toPath());

    IndexReader indexReader = DirectoryReader.open(directory);

    IndexSearcher indexSearcher = new IndexSearcher(indexReader);

    Query query = new MatchAllDocsQuery();

    TopDocs topDocs = indexSearcher.search(query, 10);

    System.out.println("查询总条数为：" + topDocs.totalHits);

    for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
      int docId = scoreDoc.doc;
      Document document = indexSearcher.doc(docId);
      System.out.println(document);
      System.out.println(document.get("person"));
    }

    indexReader.close();
  }

  public static void main(String[] args) throws IOException {
    testCreateIndex();
    testReadFromIndex();
  }
}
