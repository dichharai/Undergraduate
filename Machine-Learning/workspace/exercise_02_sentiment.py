"""Build a sentiment analysis / polarity model

Sentiment analysis can be casted as a binary text classification problem,
that is fitting a linear classifier on features extracted from the text
of the user messages so as to guess wether the opinion of the author is
positive or negative.

In this examples we will use a movie review dataset.

"""
# Author: Olivier Grisel <olivier.grisel@ensta.org>
# License: Simplified BSD

import sys
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.svm import LinearSVC
from sklearn.pipeline import Pipeline
from sklearn.grid_search import GridSearchCV
from sklearn.datasets import load_files
from sklearn.cross_validation import train_test_split
from sklearn import metrics


if __name__ == "__main__":
    # NOTE: we put the following in a 'if __name__ == "__main__"' protected
    # block to be able to use a multi-core grid search that also works under
    # Windows, see: http://docs.python.org/library/multiprocessing.html#windows
    # The multiprocessing module is used as the backend of joblib.Parallel
    # that is used when n_jobs != 1 in GridSearchCV

    # the training data folder must be passed as first argument
    movie_reviews_data_folder = sys.argv[1]
    dataset = load_files(movie_reviews_data_folder, shuffle=False)
    print("n_samples: %d" % len(dataset.data))

    # split the dataset in training and test set:
    docs_train, docs_test, y_train, y_test = train_test_split(
        dataset.data, dataset.target, test_size=0.25, random_state=None)

    # TASK: Build a vectorizer / classifier pipeline that filters out tokens
    # that are too rare or too frequent
    vectorizer = Pipeline([('vect',TfidfVectorizer(max_df = 0.95,min_df = 3)),
                          ('clf', LinearSVC(C = 1000)),
                          ])
    

    # TASK: Build a grid search to find out whether unigrams or bigrams are
    # more useful.
    # Fit the pipeline on the training set using grid search for the parameters
    parameters = {'vect__ngram_range': [(1,1),(1,2)],}
    grid_search = GridSearchCV(vectorizer, parameters,n_jobs = -1)
    gid_search = grid_search.fit(docs_train, y_train)
    

    # TASK: print the cross-validated scores for the each parameters set
    # explored by the grid search
    print(grid_search.grid_scores_)

    # TASK: Predict the outcome on the testing set and store it in a variable
    # named y_predicted
    y_predicted = grid_search.predict(docs_test)

    # Print the classification report
    print(metrics.classification_report(y_test, y_predicted,
                                        target_names=dataset.target_names))

    # Print and plot the confusion matrix
    print('Confusion Matrix')
    cm = metrics.confusion_matrix(y_test, y_predicted)
    print(cm)

    print('Confusion matrix')
    import matplotlib.pyplot as plt
    plt.matshow(cm)
    plt.show()
    
    #predict the result on some reviews
    sentences = [
        u'Is anything in this movie a spoiler? haha',
        u'I did not expect much from "'"New York"'".',
        u'This movie based on the novel of Bal Krishna Sam opens itself, showing the audiences as though it has done cent percent justice to the novel.',
        u' A hallmark of a good storyteller is making the audience empathise or pull them into the shoes of the central character. Miyazaki does this brilliantly in "'"Spirited Away"'".',
        u'The film came alive like the other Miyazaki"'" I"'"ve seen. ',
        ]
    predicted = grid_search.predict(sentences)
    for s,p in zip(sentences,predicted):
        print(u'Sentence "%s" is "%s"'%(s, dataset.target_names[p]))
