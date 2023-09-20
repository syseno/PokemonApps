#pragma once

#if defined(ENV_DEV)
#include "remoteenvars_dev.h"
#elif defined(ENV_REL)
#include "remoteenvars_rel.h"
#else
#error "Missing ENV_XX define"
#endif
