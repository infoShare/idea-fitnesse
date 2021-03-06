package fitnesse.idea.filetype

import com.intellij.navigation.ChooseByNameContributor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.{FileTypeIndex, GlobalSearchScope}

import scala.collection.JavaConversions._


class FitnesseFileNameContributor extends ChooseByNameContributor {
  override def getNames(project: Project, includeNonProjectItems: Boolean) = {
    getFitnesseFiles(includeNonProjectItems, project).map(_.getParent.getName).toArray
  }

  override def getItemsByName(name: String, pattern: String, project: Project, includeNonProjectItems: Boolean) = {
    getFitnesseFiles(includeNonProjectItems, project)
      .filter(_.getParent.getName.equalsIgnoreCase(name))
      .map(PsiManager.getInstance(project).findFile).toArray
  }

  private def getFitnesseFiles(includeNonProjectItems: Boolean, project: Project): Iterable[VirtualFile] =
    FileTypeIndex.getFiles(FitnesseFileType.INSTANCE, if (includeNonProjectItems) GlobalSearchScope.projectScope(project) else GlobalSearchScope.allScope(project))

}
