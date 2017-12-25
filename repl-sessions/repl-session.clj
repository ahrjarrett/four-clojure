;; Connected to nREPL server - nrepl://localhost:49197
;; CIDER 0.16.0snapshot (package: 20171220.135), nREPL 0.2.13
;; Clojure 1.8.0, Java 9.0.1
;;     Docs: (doc function-name)
;;           (find-doc part-of-name)
;;   Source: (source function-name)
;;  Javadoc: (javadoc java-object-or-class)
;;     Exit: <C-c C-q>
;;  Results: Stored in vars *1, *2, *3, an exception in *e;
;; ======================================================================
;; If you’re new to CIDER it is highly recommended to go through its
;; manual first. Type <M-x cider-view-manual> to view it.
;; In case you’re seeing any warnings you should consult the manual’s
;; "Troubleshooting" section.
;;
;; Here are few tips to get you started:
;;
;; * Press <C-h m> to see a list of the keybindings available (this
;;   will work in every Emacs buffer)
;; * Press <M-x cider-repl-handle-shortcut> to quickly invoke some REPL command
;; * Press <C-c C-z> to switch between the REPL and a Clojure file
;; * Press <M-x cider-find-var> to jump to the source of something (e.g. a var, a
;;   Java method)
;; * Press <C-c C-d C-d> to view the documentation for something (e.g.
;;   a var, a Java method)
;; * Enable ‘eldoc-mode’ to display function & method signatures in the minibuffer.
;; * Print CIDER’s refcard and keep it close to your keyboard.
;;
;; CIDER is super customizable - try <M-x customize-group cider> to
;; get a feel for this. If you’re thirsty for knowledge you should try
;; <M-x cider-drink-a-sip>.
;;
;; If you think you’ve encountered a bug (or have some suggestions for
;; improvements) use <M-x cider-report-bug> to report it.
;;
;; Above all else - don’t panic! In case of an emergency - procure
;; some (hard) cider and enjoy it responsibly!
;;
;; You can remove this message with the ‘cider-repl-clear-help-banner’ command.
;; You can disable it from appearing on start by setting
;; ‘cider-repl-display-help-banner’ to nil.
;; ======================================================================
four-clojure.core> (def partitioned (partition-by count [[1] [1 2] [3] [1 2 3] [2 3]]]))
RuntimeException Unmatched delimiter: ]  clojure.lang.Util.runtimeException (Util.java:221)
RuntimeException Unmatched delimiter: )  clojure.lang.Util.runtimeException (Util.java:221)
RuntimeException Unmatched delimiter: )  clojure.lang.Util.runtimeException (Util.java:221)
four-clojure.core> (def partitioned
                     (partition-by count [[1] [1 2] [3] [1 2 3] [2 3]]))
#'four-clojure.core/partitioned
four-clojure.core> partitioned
(([1]) ([1 2]) ([3]) ([1 2 3]) ([2 3]))
four-clojure.core> (def grp-seq (fn [f xs]
                                  (map #(vector (f (first %)) (vec %)) partitioned)))
                     
#'four-clojure.core/grp-seq
four-clojure.core> (grp-seq count [[1] [1 2] [3] [1 2 3] [2 3]])
([1 [[1]]] [2 [[1 2]]] [1 [[3]]] [3 [[1 2 3]]] [2 [[2 3]]])
four-clojure.core> (into {} (grp-seq count [[1] [1 2] [3] [1 2 3] [2 3]]))
{1 [[3]], 2 [[2 3]], 3 [[1 2 3]]}
four-clojure.core> 
