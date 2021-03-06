package codechicken.lib.data;

import io.netty.handler.codec.EncoderException;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidStack;

import java.io.DataOutput;
import java.io.IOException;

public class MCDataOutputWrapper implements MCDataOutput {

    public DataOutput dataout;

    public MCDataOutputWrapper(DataOutput out) {
        dataout = out;
    }

    public MCDataOutputWrapper writeBoolean(boolean b) {
        try {
            dataout.writeBoolean(b);
        } catch (IOException e) {
            throw new EncoderException(e);
        }
        return this;
    }

    public MCDataOutputWrapper writeByte(int b) {
        try {
            dataout.writeByte(b);
        } catch (IOException e) {
            throw new EncoderException(e);
        }
        return this;
    }

    public MCDataOutputWrapper writeShort(int s) {
        try {
            dataout.writeShort(s);
        } catch (IOException e) {
            throw new EncoderException(e);
        }
        return this;
    }

    public MCDataOutputWrapper writeInt(int i) {
        try {
            dataout.writeInt(i);
        } catch (IOException e) {
            throw new EncoderException(e);
        }
        return this;
    }

    public MCDataOutputWrapper writeFloat(float f) {
        try {
            dataout.writeFloat(f);
        } catch (IOException e) {
            throw new EncoderException(e);
        }
        return this;
    }

    public MCDataOutputWrapper writeDouble(double d) {
        try {
            dataout.writeDouble(d);
        } catch (IOException e) {
            throw new EncoderException(e);
        }
        return this;
    }

    public MCDataOutputWrapper writeLong(long l) {
        try {
            dataout.writeLong(l);
        } catch (IOException e) {
            throw new EncoderException(e);
        }
        return this;
    }

    @Override
    public MCDataOutputWrapper writeChar(char c) {
        try {
            dataout.writeChar(c);
        } catch (IOException e) {
            throw new EncoderException(e);
        }
        return this;
    }

    @Override
    public MCDataOutput writeVarInt(int i) {
        MCDataUtils.writeVarInt(this, i);
        return this;
    }

    @Override
    public MCDataOutput writeVarShort(int s) {
        MCDataUtils.writeVarShort(this, s);
        return this;
    }

    public MCDataOutputWrapper writeArray(byte[] barray) {
        try {
            dataout.write(barray);
        } catch (IOException e) {
            throw new EncoderException(e);
        }
        return this;
    }

    @Override
    public MCDataOutputWrapper writePos(BlockPos pos) {
        writeInt(pos.getX());
        writeInt(pos.getY());
        writeInt(pos.getZ());
        return this;
    }

    public MCDataOutputWrapper writeString(String s) {
        MCDataUtils.writeString(this, s);
        return this;
    }

    public MCDataOutputWrapper writeItemStack(ItemStack stack) {
        MCDataUtils.writeItemStack(this, stack);
        return this;
    }

    public MCDataOutputWrapper writeNBTTagCompound(NBTTagCompound nbt) {
        MCDataUtils.writeNBTTagCompount(this, nbt);
        return this;
    }

    public MCDataOutputWrapper writeFluidStack(FluidStack fluid) {
        MCDataUtils.writeFluidStack(this, fluid);
        return this;
    }
}
