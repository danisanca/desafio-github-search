package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var repoItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}
    var shareRepoLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameRepo.text = repositories[position].name
        holder.icShared.setOnClickListener {
            val repo = repositories[position]
            repoItemLister(repo)
            btnShareLister(repo)
        }
        holder.cvShared.setOnClickListener {
            val repo = repositories[position]
            shareRepoLister(repo)
        }
    }

    // Pega a quantidade de repositorios da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       val nameRepo :TextView
       val icShared : ImageView
       val cvShared : CardView
       init {
           view.apply {
               nameRepo = findViewById(R.id.tv_name_repo)
               icShared = findViewById(R.id.iv_shared)
               cvShared = findViewById(R.id.cv_repo)
           }
       }

    }
}


