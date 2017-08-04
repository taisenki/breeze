git.baseVersion := "0.13"
// append -SNAPSHOT unless we're on a branch
//git.gitUncommittedChanges := git.gitCurrentTags.value.isEmpty
// git.useGitDescribe := true

val VersionRegex = "v([0-9]+.[0-9]+.[0-9]+)-?(.*)?".r

version in ThisBuild := "0.13.2"

/*
git.gitTagToVersionNumber := {
  case VersionRegex(v, "") => Some(v)
  case VersionRegex(v, "SNAPSHOT") => Some(s"$v-SNAPSHOT")
  case VersionRegex(v, s) => Some(s"$v-$s-SNAPSHOT")
  case _ => None
}
*/
