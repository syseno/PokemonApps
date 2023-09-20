#include <jni.h>
#include <cstring>
#include "include/remoteenvars.h"

extern "C" {
JNIEXPORT jstring
Java_com_example_remote_const_RemoteEnv_getBaseUrl(JNIEnv *env, jclass cls) {
std::string env_name = remoteenvars::get_base_url();
return env->NewStringUTF(env_name.c_str());
}

}