#pragma once

// @generated by torchgen/gen.py from Function.h

#include <ATen/Context.h>
#include <ATen/DeviceGuard.h>
#include <ATen/TensorUtils.h>
#include <ATen/TracerMode.h>
#include <ATen/core/Generator.h>
#include <ATen/core/Reduction.h>
#include <ATen/core/Tensor.h>
#include <c10/core/Scalar.h>
#include <c10/core/Storage.h>
#include <c10/core/TensorOptions.h>
#include <c10/util/Deprecated.h>
#include <c10/util/Optional.h>



#include <ATen/ops/mvlgamma_ops.h>

namespace at {


// aten::mvlgamma.out(Tensor self, int p, *, Tensor(a!) out) -> Tensor(a!)
inline at::Tensor & mvlgamma_out(at::Tensor & out, const at::Tensor & self, int64_t p) {
    return at::_ops::mvlgamma_out::call(self, p, out);
}

// aten::mvlgamma.out(Tensor self, int p, *, Tensor(a!) out) -> Tensor(a!)
inline at::Tensor & mvlgamma_outf(const at::Tensor & self, int64_t p, at::Tensor & out) {
    return at::_ops::mvlgamma_out::call(self, p, out);
}

// aten::mvlgamma(Tensor self, int p) -> Tensor
inline at::Tensor mvlgamma(const at::Tensor & self, int64_t p) {
    return at::_ops::mvlgamma::call(self, p);
}

}
