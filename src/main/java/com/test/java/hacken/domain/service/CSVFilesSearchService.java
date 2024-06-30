package com.test.java.hacken.domain.service;
import org.springframework.stereotype.Service;


@Service
public class CSVFilesSearchService {
//    @PersistenceContext
//    private EntityManager entityManager;
//    private final Directory luceneIndex = new RAMDirectory();
//    private IndexSearcher searcher;
//
//    @PostConstruct
//    public void initializeLuceneIndex() throws IOException {
//        IndexReader reader = DirectoryReader.open(luceneIndex);
//        searcher = new IndexSearcher(reader);
//    }
//    public void indexEntities(List<CsvDataEntity> entities) {
//        try {
//            SearchSession searchSession = Search.session(entityManager);
//            entities.forEach(searchSession::indexingPlan);
//            searchSession.massIndexer().startAndWait();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            throw new RuntimeException("Erro ao indexar entidades no Lucene: " + e.getMessage(), e);
//        }
//    }
//
//    public List<CSVFil> search(String text) {
//        try {
//            QueryParser parser = new QueryParser("field1", new StandardAnalyzer());
//            Query query = parser.parse(text);
//
//            TopDocs topDocs = searcher.search(query, 10); // Limita a 10 resultados, ajuste conforme necessário
//            ScoreDoc[] hits = topDocs.scoreDocs;
//
//            List<CsvDataEntity> results = new ArrayList<>();
//            for (ScoreDoc hit : hits) {
//                int docId = hit.doc;
//                Document document = searcher.doc(docId);
//                Long entityId = Long.valueOf(document.get("id")); // Supondo que "id" seja o campo identificador no Lucene
//
//                CsvDataEntity entity = entityManager.find(CsvDataEntity.class, entityId);
//                if (entity != null) {
//                    results.add(entity);
//                }
//            }
//
//            return results;
//        } catch (Exception e) {
//            throw new RuntimeException("Erro ao realizar busca full-text: " + e.getMessage(), e);
//        }
//    }
}